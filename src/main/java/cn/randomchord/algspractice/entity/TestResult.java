package cn.randomchord.algspractice.entity;

// 2. 测试结果数据结构
public class TestResult {
    private String solutionName;
    private String testCaseName;
    private Object input;
    private Object expectedOutput;
    private Object actualOutput;
    private boolean success;
    private long executionTime;

    // 构造函数、getter方法省略

    public String getSolutionName() {
        return solutionName;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public Object getInput() {
        return input;
    }

    public Object getExpectedOutput() {
        return expectedOutput;
    }

    public Object getActualOutput() {
        return actualOutput;
    }

    public boolean isSuccess() {
        return success;
    }

    public long getExecutionTime() {
        return executionTime;
    }
}
