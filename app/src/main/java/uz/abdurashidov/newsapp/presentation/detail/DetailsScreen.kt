package uz.abdurashidov.newsapp.presentation.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import uz.abdurashidov.newsapp.R
import uz.abdurashidov.newsapp.domain.model.Article
import uz.abdurashidov.newsapp.presentation.Dimens.ArticleImageHeight
import uz.abdurashidov.newsapp.presentation.Dimens.MediumPadding1
import uz.abdurashidov.newsapp.presentation.detail.components.DetailsTopBar

@Composable
fun DetailsScreen(
    article: Article, event: (DetailsEvent) -> Unit, navigateUp: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsTopBar(onBrowsingClick = {
            Intent(Intent.ACTION_VIEW).also {
                it.data = Uri.parse(article.url)
                if (it.resolveActivity(context.packageManager) != null) {
                    context.startActivity(it)
                }
            }
        },
            onShareClick = {
                Intent(
                    Intent.ACTION_SEND
                ).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                }
            },
            onBookmarkClick = { event(DetailsEvent.UpsertDeleteArticle(article)) },
            onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(
                start = MediumPadding1, end = MediumPadding1
            )
        ) {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context = context).data(article.urlToImage)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(MediumPadding1))

                Text(
                    text = article.title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(
                        id = R.color.text_title
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {

}