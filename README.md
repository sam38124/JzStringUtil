[![](https://jitpack.io/v/sam38124/JzBleHelper.svg)](https://jitpack.io/#sam38124/JzStringUtil)
[![Platform](https://img.shields.io/badge/平台-%20Android%20-brightgreen.svg)](https://github.com/sam38124)
[![characteristic](https://img.shields.io/badge/特點-%20輕量級%20%7C%20簡單易用%20%20%7C%20穩定%20-brightgreen.svg)](https://github.com/sam38124)
# JzStringUtil
一套非常簡單使用的即時翻譯工具
## 目錄
* [如何導入到專案](#Import)
* [快速使用](#Use)
* [關於我](#About)

<a name="Import"></a>
## 如何導入到項目
> 支持jcenter。 <br/>

### jcenter導入方式
在app專案包的build.gradle中添加
```kotlin
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

在需要用到這個庫的module中的build.gradle中的dependencies中加入
```kotlin
dependencies {
  implementation 'com.github.sam38124:JzStringUtil:1.0'
}
```
<a name="Use"></a>
## 如何使用


#### 即時翻譯
```kotlin
//將英文翻譯成手機系統語言
 var English_TO_System="hello".translate("en",this)
//翻譯結果為你好

//將英文翻譯成日文
 var English_TO_JP="hello".translate("en","ja")
//翻譯結果為こんにちは

//自動偵測欲翻譯語言
 var autoTranslate="hello".autoTranslate(this)
//翻譯結果為你好
```
<a name="About"></a>
### 關於我
橙的電子android and ios developer

*line:sam38124

*gmail:sam38124@gmail.com
