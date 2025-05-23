package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa2a$LBSInfo extends MessageMicro<oidb_0xa2a$LBSInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 37, 42, 48}, new String[]{"msg_gpsdw", "rpt_msg_wifis", "rpt_msg_cells", "uint32_ip", "msg_attr", "int64_precision"}, new Object[]{null, null, null, 0, null, 0L}, oidb_0xa2a$LBSInfo.class);
    public oidb_0xa2a$GPS msg_gpsdw = new oidb_0xa2a$GPS();
    public final PBRepeatMessageField<oidb_0xa2a$Wifi> rpt_msg_wifis = PBField.initRepeatMessage(oidb_0xa2a$Wifi.class);
    public final PBRepeatMessageField<oidb_0xa2a$Cell> rpt_msg_cells = PBField.initRepeatMessage(oidb_0xa2a$Cell.class);
    public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
    public oidb_0xa2a$Attr msg_attr = new MessageMicro<oidb_0xa2a$Attr>() { // from class: tencent.im.oidb.cmd0xa2a.oidb_0xa2a$Attr
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField str_imei;
        public final PBBytesField str_imsi;
        public final PBBytesField str_phone_num;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_imei", "str_imsi", "str_phone_num"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0xa2a$Attr.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.str_imei = PBField.initBytes(byteStringMicro);
            this.str_imsi = PBField.initBytes(byteStringMicro);
            this.str_phone_num = PBField.initBytes(byteStringMicro);
        }
    };
    public final PBInt64Field int64_precision = PBField.initInt64(0);
}
