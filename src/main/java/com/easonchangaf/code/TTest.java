package com.easonchangaf.code;


import java.util.ArrayList;
import java.util.List;

public class TTest {


    public static class Department {
        private Integer id; // 部门ID
        private Integer parentId; // 父部门ID，根部门的parentId为null
        private List children; // 子部门列表

        // 构造方法
        public Department(Integer id, Integer parentId) {
            this.id = id;
            this.parentId = parentId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public List getChildren() {
            return children;
        }

        public void setChildren(List children) {
            this.children = children;
        }
    }
    /**
     *

     输入[{1, null}, {2, null}, {3, 1}, {4,3}]
     输出[{1, null, children: [{3,1, chiidlren: [{4,3}]}]}], {2, null}]
     */
    public static List buildDepartmentTree(List<Department> departments) {
        //TODO 将list中的全部的departments按层级结构写入在children里，返回的List里只包含顶级部门
        List<Department> result = new ArrayList<>();
        for(Department department : departments){
            if(department.getParentId()!=null){
                result.add(department);
            }
        }

        for(Department department: result){
            buildTree(department, departments);
        }
        return result;
    }

    public static void buildTree(Department department, List<Department> departments){

    }

    public static void main(String[] args) {

        String input = "[{1, null}, {2, null}, {3, 1}, {4,3}]";

    }

}

