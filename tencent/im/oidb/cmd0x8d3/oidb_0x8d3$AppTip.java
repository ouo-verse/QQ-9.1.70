package tencent.im.oidb.cmd0x8d3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8d3$AppTip extends MessageMicro<oidb_0x8d3$AppTip> {
    public static final int BYTES_ICON_FIELD_NUMBER = 2;
    public static final int BYTES_TOOLTIP_FIELD_NUMBER = 4;
    public static final int UINT32_ICON_TIME_STAMP_FIELD_NUMBER = 3;
    public static final int UINT32_REPORTID_CLICK_FIELD_NUMBER = 5;
    public static final int UINT32_REPORTID_SHOW_FIELD_NUMBER = 6;
    public static final int UINT32_TIP_INFO_SEQ_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon;
    public final PBBytesField bytes_tooltip;
    public final PBUInt32Field uint32_icon_time_stamp;
    public final PBUInt32Field uint32_reportid_click;
    public final PBUInt32Field uint32_reportid_show;
    public final PBUInt32Field uint32_tip_info_seq = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"uint32_tip_info_seq", "bytes_icon", "uint32_icon_time_stamp", "bytes_tooltip", "uint32_reportid_click", "uint32_reportid_show"}, new Object[]{0, byteStringMicro, 0, byteStringMicro, 0, 0}, oidb_0x8d3$AppTip.class);
    }

    public oidb_0x8d3$AppTip() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_icon = PBField.initBytes(byteStringMicro);
        this.uint32_icon_time_stamp = PBField.initUInt32(0);
        this.bytes_tooltip = PBField.initBytes(byteStringMicro);
        this.uint32_reportid_click = PBField.initUInt32(0);
        this.uint32_reportid_show = PBField.initUInt32(0);
    }
}
