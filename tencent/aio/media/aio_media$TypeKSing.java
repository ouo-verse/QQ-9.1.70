package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$TypeKSing extends MessageMicro<aio_media$TypeKSing> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover;
    public final PBBytesField bytes_jump;
    public final PBBytesField bytes_name;
    public final PBBytesField bytes_song;
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_singer;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58}, new String[]{"uint32_type", "uint64_id", "bytes_jump", "bytes_cover", "bytes_name", "uint64_singer", "bytes_song"}, new Object[]{0, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0L, byteStringMicro}, aio_media$TypeKSing.class);
    }

    public aio_media$TypeKSing() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_jump = PBField.initBytes(byteStringMicro);
        this.bytes_cover = PBField.initBytes(byteStringMicro);
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.uint64_singer = PBField.initUInt64(0L);
        this.bytes_song = PBField.initBytes(byteStringMicro);
    }
}
