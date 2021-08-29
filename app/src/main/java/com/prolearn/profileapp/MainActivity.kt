package com.prolearn.profileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prolearn.profileapp.model.ProfileModel
import com.prolearn.profileapp.model.profileList
import com.prolearn.profileapp.ui.theme.ProfileAppTheme
import com.prolearn.profileapp.ui.theme.Shapes
import androidx.compose.foundation.lazy.items;
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.prolearn.profileapp.model.profileList_url

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color= Color.LightGray
    ) {
//        Column() {
//            for(item in profileList){
//                ProfileCard(item)
//            }
//        }
        LazyColumn{
            items(profileList_url) { profile ->
                ProfileCard(profile)
            }
        }
    }
}

@Composable
fun ProfileCard(profileModel : ProfileModel) {
    Card(
        backgroundColor = Color.White,

        modifier = Modifier
            .padding(top = 6.dp, start = 12.dp, end = 12.dp, bottom = 6.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
            shape = RoundedCornerShape(8.dp),
            elevation = 4.dp


    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfilePicture(profileModel)
            ProfileContent(profileModel)
        }
    }
}

@Composable
fun ProfilePicture(profileModel : ProfileModel){
//    Image(
//        painter = painterResource(id = profileModel.imageid),
//        contentDescription = profileModel.imagedescription
//    )

//    Image(
//        painter = rememberImagePainter(
//            data = profileModel.imageUrl,
//            builder = {
//                crossfade(true)
//                transformations(CircleCropTransformation())
//            }
//        ),
//        modifier = Modifier.size(72.dp),
//        contentDescription = profileModel.imagedescription
//    )

    Image(
        painter = rememberImagePainter(
            data = profileModel.imageid,
            builder = {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        ),
        modifier = Modifier.size(72.dp),
        contentDescription = profileModel.imagedescription
    )
}

@Composable
fun ProfileContent(profileModel : ProfileModel){
    Column(
     modifier = Modifier.offset(x=15.dp)
    ){
        Text(
            text = profileModel.name,
            style=MaterialTheme.typography.h6,

        )

        Text(
            text = profileModel.status,
            style = MaterialTheme.typography.subtitle1,
            color = Color.Black.copy(0.4f),

        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileAppTheme {
        ProfileScreen()
    }
}