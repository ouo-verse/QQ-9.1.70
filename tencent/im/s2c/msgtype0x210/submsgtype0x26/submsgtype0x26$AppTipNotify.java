package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x26$AppTipNotify extends MessageMicro<submsgtype0x26$AppTipNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50}, new String[]{"msg_app_tip", "uint32_action", "bytes_text", "uint32_notify_seq", "uint32_needed_tip_info_seq", "opt_msg_app_notify_content"}, new Object[]{null, 0, ByteStringMicro.EMPTY, 0, 0, null}, submsgtype0x26$AppTipNotify.class);
    public submsgtype0x26$AppTip msg_app_tip = new MessageMicro<submsgtype0x26$AppTip>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$AppTip
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_icon;
        public final PBBytesField bytes_tooltip;
        public final PBUInt32Field uint32_icon_time_stamp;
        public final PBUInt32Field uint32_reportid_click;
        public final PBUInt32Field uint32_reportid_show;
        public final PBUInt32Field uint32_tip_info_seq = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"uint32_tip_info_seq", "bytes_icon", "uint32_icon_time_stamp", "bytes_tooltip", "uint32_reportid_click", "uint32_reportid_show"}, new Object[]{0, byteStringMicro, 0, byteStringMicro, 0, 0}, submsgtype0x26$AppTip.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_icon = PBField.initBytes(byteStringMicro);
            this.uint32_icon_time_stamp = PBField.initUInt32(0);
            this.bytes_tooltip = PBField.initBytes(byteStringMicro);
            this.uint32_reportid_click = PBField.initUInt32(0);
            this.uint32_reportid_show = PBField.initUInt32(0);
        }
    };
    public final PBUInt32Field uint32_action = PBField.initUInt32(0);
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_notify_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_needed_tip_info_seq = PBField.initUInt32(0);
    public submsgtype0x26$AppNotifyContent opt_msg_app_notify_content = new submsgtype0x26$AppNotifyContent();
}
