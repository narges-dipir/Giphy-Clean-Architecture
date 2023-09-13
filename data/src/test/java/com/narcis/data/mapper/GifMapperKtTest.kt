package com.narcis.data.mapper

import com.narcis.data.model.random.Data
import com.narcis.data.model.random.RandomGifResponse
import com.narcis.data.model.search.Downsized
import com.narcis.data.model.search.DownsizedMedium
import com.narcis.data.model.search.GifObject
import com.narcis.data.model.search.Images
import com.narcis.data.model.search.Original
import com.narcis.data.model.search.User
import org.junit.Test
import kotlin.test.assertEquals

class GifMapperKtTest {

    @Test
    fun `test GifObject mapper function to SearchGif`() {
        val images = Images(
            downsized = Downsized(
                height = "444",
                width = "480",
                size = "64567",
                url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
            ),
            downsizedLarge = null,
            downsizedMedium = DownsizedMedium(
                height = "444",
                width = "480",
                size = "64567",
                url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
            ),
            downsizedSmall = null,
            downsizedStill = null,
            original = Original(
                height = "444",
                width = "480",
                size = "64567",
                url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
                mp4 = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.mp4?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.mp4&ct=g",
                webp = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.webp?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.webp&ct=g",
                frames = "4",
                hash = "245473618e35d8d683691d1b7bb063cc",
            ),
        )
        val dataModel = GifObject(
            analyticsResponsePayload = "",
            bitlyGifUrl = "",
            bitlyUrl = "",
            contentUrl = "",
            embedUrl = "",
            id = "1",
            images = images,
            importDatetime = null,
            isSticker = null,
            rating = null,
            slug = null,
            source = null,
            sourcePostUrl = null,
            sourceTld = null,
            title = "gif sample",
            trendingDatetime = null,
            type = "gif",
            url = "https://giphy.com/gifs/coimma-balpass-megatroncoimma-igOgjc5yHX0oLEpL1u",
            user = User(
                username = "coimma",
                description = "Empresa do ramo agropecuário",
            ),
            username = null,
        )

        val domainModel = dataModel.mapToSearchGif()

        assertEquals(dataModel.id, domainModel.id)
        assertEquals(dataModel.images?.original?.url, domainModel.url)
        assertEquals(dataModel.images?.downsizedMedium?.url, domainModel.downSizedUrl)
        assertEquals(dataModel.title, domainModel.title)
        assertEquals(dataModel.rating, dataModel.rating)
    }

    @Test
    fun `test RandomGifResponse mapper to RandomGif`() {
        val images = Images(
            downsized = Downsized(
                height = "444",
                width = "480",
                size = "64567",
                url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
            ),
            downsizedLarge = null,
            downsizedMedium = DownsizedMedium(
                height = "444",
                width = "480",
                size = "64567",
                url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
            ),
            downsizedSmall = null,
            downsizedStill = null,
            original = Original(
                height = "444",
                width = "480",
                size = "64567",
                url = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.gif?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.gif&ct=g",
                mp4 = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.mp4?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.mp4&ct=g",
                webp = "https://media1.giphy.com/media/igOgjc5yHX0oLEpL1u/giphy.webp?cid=6df7b0feyf2kupc1kbn35fluv5satlmy7fjvmwl9siacg6jq&ep=v1_gifs_random&rid=giphy.webp&ct=g",
                frames = "4",
                hash = "245473618e35d8d683691d1b7bb063cc",
            ),
        )
        val data = Data(
            id = "2",
            rating = "pg-13",
            slug = "coimma-balpass-megatroncoimma-igOgjc5yHX0oLEpL1u",
            source = null,
            images = images,
            source_post_url = null,
            source_tld = null,
            title = "Gif Title",
            trending_datetime = "",
            type = "gif",
            url = "https://giphy.com/gifs/coimma-balpass-megatroncoimma-igOgjc5yHX0oLEpL1u",
            username = "",
        )
        val dataModel = RandomGifResponse(
            randomGifData = data,
        )
        val domainData = dataModel.mapToRandomGif()
        assertEquals(dataModel.randomGifData.id, domainData.id)
        assertEquals(dataModel.randomGifData.images?.original?.url, domainData.url)
        assertEquals(dataModel.randomGifData.rating, domainData.rating)
    }
}
