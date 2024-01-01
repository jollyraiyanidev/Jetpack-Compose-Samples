# Jetpack Compose Layout

## Developed By
[Jolly Raiyani]

### Features

1. Easy to Use,
2. Horizontal ScrollView,
3. Bottom Navigation View,
4. TextField View

## Screenshot
![image](https://github.com/jollyraiyanidev/Jetpack-Compose-Samples/assets/79997945/5adfb9cf-306d-4370-81e6-9189d53c1ecf)

## Simple Usage

### 1. Create ImageView With Text

```kotlin

 Column( horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier) {
            Image(
                painterResource(id = drawable) ,
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
```
            
            

