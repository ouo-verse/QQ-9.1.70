package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd4b$KdVideoColumnInfo extends MessageMicro<oidb_0xd4b$KdVideoColumnInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_column_intro;
    public final PBBytesField bytes_column_title;
    public final PBBytesField bytes_cover_img;
    public final PBBytesField bytes_icon_img;
    public final PBUInt32Field uint32_cover_img_style;
    public final PBUInt32Field uint32_is_special_subscribed;
    public final PBUInt64Field uint64_kd_subscribe_num;
    public final PBUInt32Field uint32_video_column_id = PBField.initUInt32(0);
    public final PBInt64Field int64_last_update_time = PBField.initInt64(0);
    public final PBUInt32Field uint32_video_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_subscribed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subscribe_num = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66, 74, 80, 88, 96}, new String[]{"uint32_video_column_id", "int64_last_update_time", "uint32_video_num", "uint32_is_subscribed", "uint32_subscribe_num", "bytes_column_title", "bytes_column_intro", "bytes_cover_img", "bytes_icon_img", "uint32_cover_img_style", "uint64_kd_subscribe_num", "uint32_is_special_subscribed"}, new Object[]{0, 0L, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0L, 0}, oidb_0xd4b$KdVideoColumnInfo.class);
    }

    public oidb_0xd4b$KdVideoColumnInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_column_title = PBField.initBytes(byteStringMicro);
        this.bytes_column_intro = PBField.initBytes(byteStringMicro);
        this.bytes_cover_img = PBField.initBytes(byteStringMicro);
        this.bytes_icon_img = PBField.initBytes(byteStringMicro);
        this.uint32_cover_img_style = PBField.initUInt32(0);
        this.uint64_kd_subscribe_num = PBField.initUInt64(0L);
        this.uint32_is_special_subscribed = PBField.initUInt32(0);
    }
}
