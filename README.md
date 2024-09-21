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

  <h1>Para recuperar os valores você usa:</h1>

   
 ```kotlin
    val transformedCpf =
            visualTransformationCpf.filter(AnnotatedString(textCpf.value)).text.text
    val transformedPhone =
            visualTransformationPhone.filter(AnnotatedString(textPhone.value)).text.text
  ```

  <h1>Não esquecer de colocar length no TextField na parte de onValueChange:</h1>
   ```kotlin
   onValueChange = { newValue ->
                if (newValue.length<=11){
                   textPhone.value = newValue
                }

            },
     ```