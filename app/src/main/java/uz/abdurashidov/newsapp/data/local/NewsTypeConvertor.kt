package uz.abdurashidov.newsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import uz.abdurashidov.newsapp.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConvertor {

    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(source: String) {
        return source.split(",").let {
            Source(it[0], it[1])
        }
    }
}