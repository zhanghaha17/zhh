package com.example.zhh.constants;

public enum Color {
    // 定义三个枚举常量，会触发构造方法
    RED("红色"),
    GREEN("绿色"),
    BLUE("蓝色");

    private String description;

    // 构造方法使用 private 修饰（枚举的构造方法默认就是 private，这里显式写出）
    private Color(String description) {
        this.description = description;
        System.out.println("枚举构造方法被调用，正在创建常量: " + this.name() + "，描述: " + description);
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        // 使用其中一个枚举常量，触发类加载和构造方法执行
        Color chosen = Color.RED;
        System.out.println("使用了枚举常量: " + chosen + "，它的描述是: " + chosen.getDescription());
    }
}