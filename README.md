<h1>Não esquecer de mudar os packages de cada arquivo.</h1>

<br />
<h1>Como usar?</h1>

```kotlin
    val visualTransformationPhone: VisualTransformation = remember { MaskPhone() }
    val visualTransformationCpf: VisualTransformation = remember { MaskCpf() }

 ```
 <h1>Depois é só inserir no TextField:</h1>
 ```kotlin
 visualTransformation = visualTransformationPhone,
 visualTransformation = visualTransformationCpf
  ```
