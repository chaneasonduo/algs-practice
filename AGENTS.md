# AGENTS.md

## 项目简介

算法学习仓库，用于记录和练习 LeetCode 题目，包含 Java 和 Python 两种实现。

## 项目结构

```
algs-practice/
├── java-args/          # Java 算法练习（Maven 项目，Java 17）
│   └── src/test/java/com/easonchangaf/
│       ├── leetcodeHot100/       # LeetCode Hot 100
│       └── leetcodeInterview150/ # LeetCode 面试 150
├── py-algs/            # Python 算法练习
│   └── leetcodeHot100/           # LeetCode Hot 100
└── src/                # 旧的 Java 代码（已迁移到 java-args/）
```

## 文件命名规范

| 语言 | 命名格式 | 示例 |
|------|----------|------|
| Java | `Q{题号}_{题目简称}.java` | `Q108_sortedArrayToB.java` |
| Python | `Q{题号}_{题目简称}.py` | `Q49_GroupAnagrams.py` |

部分老文件使用 `LCR{题号}` 前缀（LeetCode CN 剑指 Offer）。

## 代码规范

### 核心原则

**这是算法学习仓库，只写方法签名和注释，不实现解法。**

- 方法体留空（`pass` / 空方法体）
- 注释中记录题目描述、示例、约束
- 保留 `main` 或 `@Test` 入口用于后续自己实现和测试

### Python 文件模板

```python
"""
{题号}. {题目名}
{LeetCode 链接}

{题目描述}

Example 1:
    Input: ...
    Output: ...

Constraints:
    ...
"""

from typing import List

class Qxx_ProblemName:
    def solution(self, ...):
        pass

if __name__ == "__main__":
    alg = Qxx_ProblemName()
    cases = [...]
    for i, case in enumerate(cases, 1):
        print(f"======= case {i} =======")
        print(alg.solution(case))
```

### Java 文件模板

```java
package com.easonchangaf.leetcodeHot100;

import org.junit.Test;

/**
 * {题目描述}
 * {LeetCode 链接}
 */
public class Qxx_ProblemName {

    private int[] case1 = {...};

    public ReturnType solution(...) {
        // TODO: 自己实现
        return null;
    }

    @Test
    public void solution_test() {
        // 测试入口
    }
}
```

## 包/目录选择

| 题集 | 目录 |
|------|------|
| LeetCode Hot 100 | `leetcodeHot100/` |
| LeetCode 面试经典 150 | `leetcodeInterview150/` |

## 构建与运行

```bash
# Java
cd java-args
mvn compile
mvn test

# Python - 直接运行
python py-algs/leetcodeHot100/Q49_GroupAnagrams.py
```

## 注意事项

- 不要自动实现算法解法
- 保持题目描述、示例、约束的完整注释
- 文件按题号排序放置
