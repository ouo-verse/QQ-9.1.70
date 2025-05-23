package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$ReqShareTransCheck extends MessageMicro<aio_media$ReqShareTransCheck> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_song_name;
    public final PBBytesField bytes_song_url;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_singer;
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_share_appid = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"enum_aio_type", "uint64_id", "uint32_share_appid", "bytes_song_name", "rpt_bytes_singer", "bytes_song_url"}, new Object[]{1, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro}, aio_media$ReqShareTransCheck.class);
    }

    public aio_media$ReqShareTransCheck() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_song_name = PBField.initBytes(byteStringMicro);
        this.rpt_bytes_singer = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.bytes_song_url = PBField.initBytes(byteStringMicro);
    }
}
