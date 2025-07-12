package com.easonchangaf.leetcodeInterview150;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 验证有效的数独
 * LeetCode 36: Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 */
public class Q36_IsValidSudoku {

    /**
     * 将字符串格式的数独数据转换为char二维数组
     * @param input 字符串格式的数独数据
     * @return char二维数组
     */
    public char[][] convertStringToCharArray(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new char[0][0];
        }
        
        // 移除开头和结尾的方括号
        String cleaned = input.trim();
        if (cleaned.startsWith("[") && cleaned.endsWith("]")) {
            cleaned = cleaned.substring(1, cleaned.length() - 1);
        }
        
        // 分割每一行
        String[] rows = cleaned.split("\\],\\[");
        
        // 处理第一行和最后一行的方括号
        if (rows.length > 0) {
            if (rows[0].startsWith("[")) {
                rows[0] = rows[0].substring(1);
            }
            if (rows[rows.length - 1].endsWith("]")) {
                rows[rows.length - 1] = rows[rows.length - 1].substring(0, rows[rows.length - 1].length() - 1);
            }
        }
        
        int numRows = rows.length;
        char[][] result = new char[numRows][];
        
        for (int i = 0; i < numRows; i++) {
            // 分割每个元素
            String[] elements = rows[i].split(",");
            result[i] = new char[elements.length];
            
            for (int j = 0; j < elements.length; j++) {
                String element = elements[j].trim();
                // 移除引号
                if (element.startsWith("\"") && element.endsWith("\"")) {
                    element = element.substring(1, element.length() - 1);
                }
                
                // 转换为字符
                if (element.equals(".") || element.isEmpty()) {
                    result[i][j] = '.';
                } else {
                    result[i][j] = element.charAt(0);
                }
            }
        }
        
        return result;
    }
    
    /**
     * 打印char二维数组（用于调试）
     * @param board char二维数组
     */
    public void printCharArray(char[][] board) {
        if (board == null || board.length == 0) {
            System.out.println("Empty board");
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("\"" + board[i][j] + "\"");
                if (j < board[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }
    
    /**
     * 算法实现部分 - 请在这里实现您的算法
     * @param board 9x9的数独板
     * @return 如果是有效的数独返回true，否则返回false
     */
    public boolean solution(char[][] board) {
        // TODO: 请在这里实现您的算法
        // 提示：
        // 1. 检查每一行是否包含重复数字
        // 2. 检查每一列是否包含重复数字  
        // 3. 检查每个3x3的子网格是否包含重复数字
        // 4. 空单元格用'.'表示，可以忽略
        return false;
    }
    
    // ========== 测试用例 ==========
    
    @Test
    public void testValidSudoku() {
        // 测试用例1: 有效的数独
        String input1 = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
        char[][] board1 = convertStringToCharArray(input1);
        
        System.out.println("测试用例1 - 有效的数独:");
        printCharArray(board1);
        assertTrue(solution(board1), "有效的数独应该返回true");
    }
    
    @Test
    public void testInvalidSudoku() {
        // 测试用例2: 无效的数独（第一行有重复的8）
        String input2 = "[[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
        char[][] board2 = convertStringToCharArray(input2);
        
        System.out.println("测试用例2 - 无效的数独（第一行有重复的8）:");
        printCharArray(board2);
        assertFalse(solution(board2), "无效的数独应该返回false");
    }
    
    @Test
    public void testInvalidSudokuColumn() {
        // 测试用例3: 无效的数独（第一列有重复的8）
        String input3 = "[[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
        char[][] board3 = convertStringToCharArray(input3);
        
        System.out.println("测试用例3 - 无效的数独（第一列有重复的8）:");
        printCharArray(board3);
        assertFalse(solution(board3), "无效的数独应该返回false");
    }
    
    @Test
    public void testInvalidSudokuBox() {
        // 测试用例4: 无效的数独（第一个3x3子网格有重复的8）
        String input4 = "[[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
        char[][] board4 = convertStringToCharArray(input4);
        
        System.out.println("测试用例4 - 无效的数独（第一个3x3子网格有重复的8）:");
        printCharArray(board4);
        assertFalse(solution(board4), "无效的数独应该返回false");
    }
    
    @Test
    public void testEmptyBoard() {
        // 测试用例5: 空板（应该返回true）
        char[][] board5 = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board5[i][j] = '.';
            }
        }
        
        System.out.println("测试用例5 - 空板:");
        printCharArray(board5);
        assertTrue(solution(board5), "空板应该返回true");
    }
    
    @Test
    public void testAlmostCompleteValidSudoku() {
        // 测试用例6: 几乎完整的有效数独
        String input6 = "[[\"5\",\"3\",\"4\",\"6\",\"7\",\"8\",\"9\",\"1\",\"2\"],[\"6\",\"7\",\"2\",\"1\",\"9\",\"5\",\"3\",\"4\",\"8\"],[\"1\",\"9\",\"8\",\"3\",\"4\",\"2\",\"5\",\"6\",\"7\"],[\"8\",\"5\",\"9\",\"7\",\"6\",\"1\",\"4\",\"2\",\"3\"],[\"4\",\"2\",\"6\",\"8\",\"5\",\"3\",\"7\",\"9\",\"1\"],[\"7\",\"1\",\"3\",\"9\",\"2\",\"4\",\"8\",\"5\",\"6\"],[\"9\",\"6\",\"1\",\"5\",\"3\",\"7\",\"2\",\"8\",\"4\"],[\"2\",\"8\",\"7\",\"4\",\"1\",\"9\",\"6\",\"3\",\"5\"],[\"3\",\"4\",\"5\",\"2\",\"8\",\"6\",\"1\",\"7\",\"9\"]]";
        char[][] board6 = convertStringToCharArray(input6);
        
        System.out.println("测试用例6 - 几乎完整的有效数独:");
        printCharArray(board6);
        assertTrue(solution(board6), "几乎完整的有效数独应该返回true");
    }
    
    @Test
    public void testNullBoard() {
        // 测试用例7: null输入
        assertFalse(solution(null), "null输入应该返回false");
    }
    
    @Test
    public void testInvalidSizeBoard() {
        // 测试用例8: 错误大小的板
        char[][] board8 = new char[8][9]; // 8行9列，不是9x9
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                board8[i][j] = '.';
            }
        }
        
        System.out.println("测试用例8 - 错误大小的板:");
        printCharArray(board8);
        assertFalse(solution(board8), "错误大小的板应该返回false");
    }
    
    /**
     * 运行所有测试用例
     */
    @Test
    public void runAllTests() {
        System.out.println("=== 开始运行所有测试用例 ===");
        
        testValidSudoku();
        testInvalidSudoku();
        testInvalidSudokuColumn();
        testInvalidSudokuBox();
        testEmptyBoard();
        testAlmostCompleteValidSudoku();
        testNullBoard();
        testInvalidSizeBoard();
        
        System.out.println("=== 所有测试用例运行完成 ===");
    }

    @Test
    public void simple() {
        int index = '1' - '0';
        System.out.println(index);
    }
    
    /**
     * 查看字符的ASCII编码值
     */
    @Test
    public void showAsciiValues() {
        System.out.println("=== 数字字符的ASCII编码 ===");
        for (char c = '0'; c <= '9'; c++) {
            System.out.println("字符 '" + c + "' 的ASCII值: " + (int)c);
        }
        
        System.out.println("\n=== 字母字符的ASCII编码 ===");
        System.out.println("大写字母:");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print("'" + c + "':" + (int)c + " ");
            if ((c - 'A' + 1) % 10 == 0) System.out.println();
        }
        
        System.out.println("\n\n小写字母:");
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print("'" + c + "':" + (int)c + " ");
            if ((c - 'a' + 1) % 10 == 0) System.out.println();
        }
        
        System.out.println("\n\n=== 特殊字符的ASCII编码 ===");
        char[] specialChars = {'.', ' ', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '=', '[', ']', '{', '}', '|', '\\', ':', ';', '"', '\'', ',', '<', '>', '/', '?'};
        for (char c : specialChars) {
            System.out.println("字符 '" + c + "' 的ASCII值: " + (int)c);
        }
        
        System.out.println("\n=== 字符转换演示 ===");
        char testChar = '5';
        System.out.println("字符 '" + testChar + "' 的ASCII值: " + (int)testChar);
        System.out.println("字符 '0' 的ASCII值: " + (int)'0');
        System.out.println("转换结果: " + testChar + " - '0' = " + (testChar - '0'));
        System.out.println("验证: " + (int)testChar + " - " + (int)'0' + " = " + ((int)testChar - (int)'0'));
    }
    
    /**
     * Java中获取字符ASCII码的工具方法
     */
    public static class AsciiUtils {
        
        /**
         * 方法1: 使用强制类型转换获取ASCII码
         * @param c 字符
         * @return ASCII码值
         */
        public static int getAsciiValue1(char c) {
            return (int) c;
        }
        
        /**
         * 方法2: 使用Character.getNumericValue()获取数字字符的值
         * @param c 数字字符
         * @return 数字值，如果不是数字字符返回-1
         */
        public static int getNumericValue(char c) {
            return Character.getNumericValue(c);
        }
        
        /**
         * 方法3: 使用Character.digit()获取数字字符的值
         * @param c 数字字符
         * @param radix 进制（通常为10）
         * @return 数字值，如果不是数字字符返回-1
         */
        public static int getDigitValue(char c, int radix) {
            return Character.digit(c, radix);
        }
        
        /**
         * 方法4: 检查字符是否为数字
         * @param c 字符
         * @return 如果是数字字符返回true
         */
        public static boolean isDigit(char c) {
            return Character.isDigit(c);
        }
        
        /**
         * 方法5: 检查字符是否为字母
         * @param c 字符
         * @return 如果是字母返回true
         */
        public static boolean isLetter(char c) {
            return Character.isLetter(c);
        }
        
        /**
         * 方法6: 检查字符是否为大写字母
         * @param c 字符
         * @return 如果是大写字母返回true
         */
        public static boolean isUpperCase(char c) {
            return Character.isUpperCase(c);
        }
        
        /**
         * 方法7: 检查字符是否为小写字母
         * @param c 字符
         * @return 如果是小写字母返回true
         */
        public static boolean isLowerCase(char c) {
            return Character.isLowerCase(c);
        }
        
        /**
         * 方法8: 将字符转换为大写
         * @param c 字符
         * @return 大写字符
         */
        public static char toUpperCase(char c) {
            return Character.toUpperCase(c);
        }
        
        /**
         * 方法9: 将字符转换为小写
         * @param c 字符
         * @return 小写字符
         */
        public static char toLowerCase(char c) {
            return Character.toLowerCase(c);
        }
        
        /**
         * 方法10: 获取字符的Unicode代码点
         * @param c 字符
         * @return Unicode代码点
         */
        public static int getCodePoint(char c) {
            return Character.codePointAt(new char[]{c}, 0);
        }
    }
    
    /**
     * 测试各种ASCII码获取方法
     */
    @Test
    public void testAsciiUtils() {
        System.out.println("=== 测试ASCII码获取工具方法 ===");
        
        char testChar = '5';
        System.out.println("测试字符: '" + testChar + "'");
        System.out.println("方法1 - 强制类型转换: " + AsciiUtils.getAsciiValue1(testChar));
        System.out.println("方法2 - getNumericValue: " + AsciiUtils.getNumericValue(testChar));
        System.out.println("方法3 - getDigitValue: " + AsciiUtils.getDigitValue(testChar, 10));
        System.out.println("方法4 - isDigit: " + AsciiUtils.isDigit(testChar));
        System.out.println("方法10 - getCodePoint: " + AsciiUtils.getCodePoint(testChar));
        
        System.out.println("\n=== 测试字母字符 ===");
        char letterChar = 'A';
        System.out.println("测试字符: '" + letterChar + "'");
        System.out.println("ASCII值: " + AsciiUtils.getAsciiValue1(letterChar));
        System.out.println("isLetter: " + AsciiUtils.isLetter(letterChar));
        System.out.println("isUpperCase: " + AsciiUtils.isUpperCase(letterChar));
        System.out.println("toLowerCase: " + AsciiUtils.toLowerCase(letterChar));
        
        System.out.println("\n=== 测试特殊字符 ===");
        char specialChar = '.';
        System.out.println("测试字符: '" + specialChar + "'");
        System.out.println("ASCII值: " + AsciiUtils.getAsciiValue1(specialChar));
        System.out.println("isDigit: " + AsciiUtils.isDigit(specialChar));
        System.out.println("isLetter: " + AsciiUtils.isLetter(specialChar));
    }

}
