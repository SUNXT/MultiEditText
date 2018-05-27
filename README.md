# MultiEditText
自定义的android输入框控件
属性：
<!-- Cancel ImageView -->
        <attr name="showCancelButton" format="boolean"/>
        <attr name="cancelButtonSrc" format="integer"/>
        <attr name="cancelButtonSize" format="dimension"/>
<!-- EditText -->
        <attr name="hint" format="string|integer"/>
        <attr name="hintColor" format="color"/>
        <attr name="text" format="string|integer"/>
        <attr name="textColor" format="color"/>
        <attr name="SingleLine" format="boolean"/>
        <attr name="inputPassword" format="boolean"/>
        <attr name="inputNumber" format="boolean"/>
        <attr name="textSize" format="dimension"/>

导入到你的项目中：
Android studio
1. protect 的gradle文件 build.gradle
添加指定maven {url 'https://jitpack.io'}

如下：
allprojects {
    repositories {
        jcenter()
        maven {url 'https://jitpack.io'}
    }
}

2. 在app的gradle 文件中 build.gradle
添加依赖
compile 'com.github.sunxt:MultiEditText:1.0.6'

如下：
dependencies {
    compile 'com.android.support:appcompat-v7:25.3.0'
    compile 'com.android.support:support-v4:25.3.0'
    
    compile 'com.github.sunxt:MultiEditText:1.0.6'
}

然后就可以在你的项目中使用了MultiEditText
