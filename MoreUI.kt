
class TypeMore {
    var img:Uri? = null
    var text:String? = null
    var title:String? = null
}

@Composable
fun MoreGrid(db:List<TypeMore>, title:String) {
    Column {
        Text(
            text = title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )
        LazyRow(userScrollEnabled = true){
            items(db) {
                MoreBoxUI(Tiny = it, 200)
            }
        }
    }
}
@Composable
fun MoreBoxUI(Tiny:TypeMore, he:Int) {
    Box(modifier = Modifier
        .padding(10.dp)
        .size(160.dp, he.dp)
        .clip(RoundedCornerShape(25.dp))
        .background(Color.White)
        .border(1.dp, Gry, RoundedCornerShape(25.dp)),
        contentAlignment = Alignment.BottomCenter
        ) {
        Row(modifier = Modifier.align(Alignment.TopCenter)) {
            Tiny.day?.let{ Text(text = it, color = Gry) }
        }
        Column {
            val but = remember{mutableStateOf(false)}
            Tiny.img?.let {

            }
            Tiny.title?.let { Text(
                text = it,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp)
            )}
            Tiny.text?.let { Text(
                text = it,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clickable {
                        but.value=!but.value
                    }
            ) }

            AnimatedVisibility(visible =but.value) {

            }
        }
    }
}
