package tencent.im.video_url;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class video_url$ReqBody extends MessageMicro<video_url$ReqBody> {
    public static final int BYTES_MACHINE_INFO_FIELD_NUMBER = 3;
    public static final int BYTES_MOBILEQ_VER_FIELD_NUMBER = 6;
    public static final int BYTES_SHARE_URL_FIELD_NUMBER = 1;
    public static final int UINT32_CUR_PLAY_TIME_FIELD_NUMBER = 5;
    public static final int UINT32_NETWORK_TYPE_FIELD_NUMBER = 4;
    public static final int UINT32_PLATFORM_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_machine_info;
    public final PBBytesField bytes_mobileQ_ver;
    public final PBBytesField bytes_share_url;
    public final PBUInt32Field uint32_cur_play_time;
    public final PBUInt32Field uint32_network_type;
    public final PBUInt32Field uint32_platform_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50}, new String[]{"bytes_share_url", "uint32_platform_type", "bytes_machine_info", "uint32_network_type", "uint32_cur_play_time", "bytes_mobileQ_ver"}, new Object[]{byteStringMicro, 0, byteStringMicro, 0, 0, byteStringMicro}, video_url$ReqBody.class);
    }

    public video_url$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_share_url = PBField.initBytes(byteStringMicro);
        this.uint32_platform_type = PBField.initUInt32(0);
        this.bytes_machine_info = PBField.initBytes(byteStringMicro);
        this.uint32_network_type = PBField.initUInt32(0);
        this.uint32_cur_play_time = PBField.initUInt32(0);
        this.bytes_mobileQ_ver = PBField.initBytes(byteStringMicro);
    }
}
