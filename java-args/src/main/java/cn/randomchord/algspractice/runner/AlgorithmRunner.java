package cn.randomchord.algspractice.runner;

// 3. 核心运行引擎
import cn.randomchord.algspractice.entity.TestResult;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgorithmRunner {
    private final Map<Method, List<Method>> solutionToTestCases = new HashMap<>();
    private final List<TestResult> results = new ArrayList<>();

    // 扫描并注册所有算法类
    public void scanAndRegister(String packageName) {
        // 使用类路径扫描工具（如Reflections）查找所有@Algorithm类
        // 遍历每个类，找出@Solution和@TestCase方法并建立映射
    }

    // 执行所有测试
//    public void executeAllTests() {
//        for (Map.Entry<Method, List<Method>> entry : solutionToTestCases.entrySet()) {
//            Method solutionMethod = entry.getKey();
//            Object instance = createInstance(solutionMethod.getDeclaringClass());
//
//            for (Method testCaseMethod : entry.getValue()) {
//                executeTest(instance, solutionMethod, testCaseMethod);
//            }
//        }
//    }

    // 执行单个测试
//    private void executeTest(Object instance, Method solutionMethod, Method testCaseMethod) {
//        try {
//            // 获取测试数据
//            Object testData = testCaseMethod.invoke(instance);
//
//            // 执行解决方案
//            long startTime = System.nanoTime();
//            Object result = solutionMethod.invoke(instance, testData);
//            long endTime = System.nanoTime();
//
//            // 验证结果（这里简化处理，实际可能需要更复杂的断言机制）
//            boolean success = validateResult(result, testData);
//
//            // 记录结果
//            results.add(new TestResult(
//                    solutionMethod.getName(),
//                    testCaseMethod.getName(),
//                    testData,
//                    getExpectedOutput(testData), // 从测试数据中提取预期结果
//                    result,
//                    success,
//                    endTime - startTime
//            ));
//        } catch (InvocationTargetException | IllegalAccessException e) {
//            // 处理异常
//        }
//    }

    // 输出测试报告
    public void printReport() {
        // 格式化输出测试结果
        for (TestResult result : results) {
            System.out.printf(
                    "测试 %s.%s: %s (耗时: %d ns)%n",
                    result.getSolutionName(),
                    result.getTestCaseName(),
                    result.isSuccess() ? "通过" : "失败",
                    result.getExecutionTime()
            );
        }
    }

    // 其他辅助方法
    private Object createInstance(Class<?> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("无法实例化算法类", e);
        }
    }

//    public static void run(String... packageNames) {
//        AlgorithmRunner runner = new AlgorithmRunner();
//
//        // 扫描指定包中的所有算法类
//        for (String packageName : packageNames) {
//            runner.scanAndRegister(packageName);
//        }
//
//        // 执行测试
//        runner.executeAllTests();
//
//        // 输出报告
//        runner.printReport();
//    }
}
