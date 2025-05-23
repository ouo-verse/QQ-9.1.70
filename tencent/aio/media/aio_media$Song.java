package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$Song extends MessageMicro<aio_media$Song> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover;
    public final PBBytesField bytes_lyric;
    public final PBBytesField bytes_name;
    public final PBBytesField bytes_sub_title;
    public final PBEnumField enum_song_source;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_download_url;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_singer;
    public final PBStringField str_song_id = PBField.initString("");
    public final PBUInt32Field uint32_duration;
    public final PBUInt64Field uint64_sharer_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72, 80}, new String[]{"str_song_id", "bytes_name", "bytes_sub_title", "rpt_bytes_singer", "rpt_bytes_download_url", "bytes_lyric", "bytes_cover", "uint32_duration", "enum_song_source", "uint64_sharer_uin"}, new Object[]{"", byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 1, 0L}, aio_media$Song.class);
    }

    public aio_media$Song() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.bytes_sub_title = PBField.initBytes(byteStringMicro);
        PBBytesField pBBytesField = PBBytesField.__repeatHelper__;
        this.rpt_bytes_singer = PBField.initRepeat(pBBytesField);
        this.rpt_bytes_download_url = PBField.initRepeat(pBBytesField);
        this.bytes_lyric = PBField.initBytes(byteStringMicro);
        this.bytes_cover = PBField.initBytes(byteStringMicro);
        this.uint32_duration = PBField.initUInt32(0);
        this.enum_song_source = PBField.initEnum(1);
        this.uint64_sharer_uin = PBField.initUInt64(0L);
    }
}
