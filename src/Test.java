import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Test {

    public static void main(String[] args) {
        // 입력 파일과 출력 파일 경로를 지정합니다.
        String inputFilePath = "/Users/ohhyunkwon/Downloads/MESSAGE (4).sql";
        String outputFilePath = "/Users/ohhyunkwon/Downloads/MESSAGECONVERT (44).sql";

        // PK 값을 제거하지 않을 테이블 리스트를 대문자로 저장합니다.
        Set<String> tablesToSkip = new HashSet<>(Arrays.asList(
                "MEMBER_CATEGORY", "CHATROOM_GROUP", "MEMBER_ANSWER", "MEMBER_SMS", "MEMBER_EMAIL"
        ));

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            StringBuilder queryBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                // 현재 라인을 쿼리 빌더에 추가
                queryBuilder.append(line).append("\n");

                // 세미콜론으로 쿼리의 끝을 확인
                if (line.trim().endsWith(";")) {
                    // 하나의 전체 쿼리를 가져옴
                    String query = queryBuilder.toString();

                    // 테이블 이름을 추출
                    String tableName = getTableName(query);
                    if (tableName != null && tablesToSkip.contains(tableName.toUpperCase())) {
                        // 테이블이 제외 리스트에 있으면 원본 쿼리 사용
                        writer.write(query);
                    } else {
                        // PK 값을 제거한 쿼리 생성
                        String modifiedQuery = removePrimaryKey(query);
                        writer.write(modifiedQuery);
                    }

                    // 쿼리 빌더 초기화
                    queryBuilder.setLength(0);
                }
                // 세미콜론이 없으면 다음 줄로 계속 진행하여 쿼리를 완성
            }

            System.out.println("처리가 완료되었습니다. 결과는 " + outputFilePath + " 파일에서 확인하세요.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 쿼리에서 테이블 이름을 추출하는 메서드
    private static String getTableName(String query) {
        Pattern pattern = Pattern.compile("INSERT\\s+INTO\\s+[`\"]?(\\w+)[`\"]?", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(query);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    // INSERT 문에서 PK 값을 제거하는 메서드
    private static String removePrimaryKey(String query) {
        // 컬럼 리스트와 값 리스트를 분리하는 정규식 패턴
        Pattern pattern = Pattern.compile(
                "INSERT\\s+INTO\\s+[`\"]?\\w+[`\"]?\\s*\\(([^)]+)\\)\\s*VALUES\\s*\\(([^)]+)\\)",
                Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(query);
        if (matcher.find()) {
            String columnsPart = matcher.group(1);
            String valuesPart = matcher.group(2);

            // 컬럼과 값을 각각 분리하여 배열로 저장
            String[] columns = columnsPart.split(",\\s*");
            String[] values = splitValues(valuesPart);

            if (columns.length != values.length) {
                // 컬럼 수와 값 수가 맞지 않으면 원본 반환
                return query;
            }

            // 첫 번째 컬럼과 값을 제거
            String[] newColumns = Arrays.copyOfRange(columns, 1, columns.length);
            String[] newValues = Arrays.copyOfRange(values, 1, values.length);

            // 새로운 컬럼과 값 부분을 생성
            String newColumnsPart = String.join(", ", newColumns);
            String newValuesPart = String.join(", ", newValues);

            // 새로운 쿼리 생성
            String tableName = getTableName(query);
            String modifiedQuery = "INSERT INTO " + tableName + " (" + newColumnsPart + ") VALUES (" + newValuesPart + ");\n";
            return modifiedQuery;
        }
        return query; // 매칭되지 않으면 원본 반환
    }

    // 값 리스트를 처리하는 메서드 (문자열 내부의 쉼표를 무시)
    private static String[] splitValues(String valuesPart) {
        List<String> values = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inString = false;
        char stringChar = 0;

        for (int i = 0; i < valuesPart.length(); i++) {
            char c = valuesPart.charAt(i);

            if (inString) {
                sb.append(c);
                if (c == stringChar) {
                    inString = false;
                } else if (c == '\\') {
                    // 이스케이프 문자 처리
                    i++;
                    if (i < valuesPart.length()) {
                        sb.append(valuesPart.charAt(i));
                    }
                }
            } else {
                if (c == '\'' || c == '\"') {
                    inString = true;
                    stringChar = c;
                    sb.append(c);
                } else if (c == ',') {
                    values.add(sb.toString().trim());
                    sb.setLength(0);
                } else {
                    sb.append(c);
                }
            }
        }
        // 마지막 값 추가
        if (sb.length() > 0) {
            values.add(sb.toString().trim());
        }

        return values.toArray(new String[0]);
    }
}