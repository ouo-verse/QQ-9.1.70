package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$ReqShareTrans extends MessageMicro<aio_media$ReqShareTrans> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_cut_song;
    public final PBBytesField bytes_cover;
    public final PBBytesField bytes_song_name;
    public final PBBytesField bytes_song_url;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_singer;
    public final PBStringField str_song_id;
    public final PBUInt32Field uint32_duration;
    public final PBUInt64Field uint64_sharer_uin;
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_share_appid = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 66, 72, 80, 90}, new String[]{"enum_aio_type", "uint64_id", "uint32_share_appid", "bytes_song_name", "rpt_bytes_singer", "bytes_song_url", "bool_cut_song", "str_song_id", "uint32_duration", "uint64_sharer_uin", "bytes_cover"}, new Object[]{1, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, Boolean.FALSE, "", 0, 0L, byteStringMicro}, aio_media$ReqShareTrans.class);
    }

    public aio_media$ReqShareTrans() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_song_name = PBField.initBytes(byteStringMicro);
        this.rpt_bytes_singer = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.bytes_song_url = PBField.initBytes(byteStringMicro);
        this.bool_cut_song = PBField.initBool(false);
        this.str_song_id = PBField.initString("");
        this.uint32_duration = PBField.initUInt32(0);
        this.uint64_sharer_uin = PBField.initUInt64(0L);
        this.bytes_cover = PBField.initBytes(byteStringMicro);
    }
}
