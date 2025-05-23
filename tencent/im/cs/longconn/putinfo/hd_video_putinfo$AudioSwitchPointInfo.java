package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class hd_video_putinfo$AudioSwitchPointInfo extends MessageMicro<hd_video_putinfo$AudioSwitchPointInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nowifi_words;
    public final PBBytesField bytes_wifi_words;
    public final PBUInt32Field uint32_nowifi_pack_loss;
    public final PBUInt32Field uint32_nowifi_pack_loss_rate;
    public final PBUInt32Field uint32_nowifi_shake;
    public final PBUInt32Field uint32_nowifi_time_delay;
    public final PBUInt32Field uint32_wifi_shake = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wifi_time_delay = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wifi_pack_loss = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wifi_pack_loss_rate = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 50, 56, 64, 72, 80, 98}, new String[]{"uint32_wifi_shake", "uint32_wifi_time_delay", "uint32_wifi_pack_loss", "uint32_wifi_pack_loss_rate", "bytes_wifi_words", "uint32_nowifi_shake", "uint32_nowifi_time_delay", "uint32_nowifi_pack_loss", "uint32_nowifi_pack_loss_rate", "bytes_nowifi_words"}, new Object[]{0, 0, 0, 0, byteStringMicro, 0, 0, 0, 0, byteStringMicro}, hd_video_putinfo$AudioSwitchPointInfo.class);
    }

    public hd_video_putinfo$AudioSwitchPointInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_wifi_words = PBField.initBytes(byteStringMicro);
        this.uint32_nowifi_shake = PBField.initUInt32(0);
        this.uint32_nowifi_time_delay = PBField.initUInt32(0);
        this.uint32_nowifi_pack_loss = PBField.initUInt32(0);
        this.uint32_nowifi_pack_loss_rate = PBField.initUInt32(0);
        this.bytes_nowifi_words = PBField.initBytes(byteStringMicro);
    }
}
