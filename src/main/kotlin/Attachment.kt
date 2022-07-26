interface Attachment {
    val type: String
}

class Attachments {
    var attachments = emptyArray<Attachment>()

    fun add(attachment: Attachment): Attachment {
        attachments += attachment
        return attachments.last()
    }
}

class Photo(
    val id: Int,
    val albumId: Int,
    val userId: Int,
    val text: String
)

class PhotoAttachment(
    override val type: String = "Photo",
    val photo: Photo
) : Attachment

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val date: Int
)

class VideoAttachment(
    override val type: String = "Video",
    val video: Video
) : Attachment

class Audio(
    val id: Int,
    val ownerId: Int,
    val userId: Int,
    val albumId: Int
)

class AudioAttachment(
    override val type: String = "Audio",
    val audio: Audio
) : Attachment

class Document(
    val id: Int,
    val ownerId: Int,
    val title: Int,
    val size: String
)

class DocumentAttachment(
    override val type: String = "Document",
    val document: Document
) : Attachment

class Page(
    val id: Int,
    val title: String,
    val views: Int,
    val created: Int,
    val view_url: String
)

class PageAttachment(
    override val type: String = "Page",
    val page: Page
) : Attachment