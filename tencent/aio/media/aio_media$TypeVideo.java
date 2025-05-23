package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$TypeVideo extends MessageMicro<aio_media$TypeVideo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover;
    public final PBBytesField bytes_jump;
    public final PBBytesField bytes_name;
    public final PBBytesField bytes_video_jump_value;
    public final PBEnumField enum_video_jump_type;
    public final PBEnumField enum_video_type;
    public final PBBytesField match_id;
    public final PBUInt32Field uint32_polling;
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56, 64, 74, 82}, new String[]{"uint32_type", "uint64_id", "bytes_jump", "bytes_cover", "uint32_polling", "bytes_name", "enum_video_type", "enum_video_jump_type", "bytes_video_jump_value", "match_id"}, new Object[]{0, 0L, byteStringMicro, byteStringMicro, 0, byteStringMicro, 1, 1, byteStringMicro, byteStringMicro}, aio_media$TypeVideo.class);
    }

    public aio_media$TypeVideo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_jump = PBField.initBytes(byteStringMicro);
        this.bytes_cover = PBField.initBytes(byteStringMicro);
        this.uint32_polling = PBField.initUInt32(0);
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.enum_video_type = PBField.initEnum(1);
        this.enum_video_jump_type = PBField.initEnum(1);
        this.bytes_video_jump_value = PBField.initBytes(byteStringMicro);
        this.match_id = PBField.initBytes(byteStringMicro);
    }
}
