package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$TabInfo extends MessageMicro<oidb_0xc26$TabInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_0xc26$Color background_color_select;
    public oidb_0xc26$Color background_color_unselect;
    public final PBBytesField bytes_icon_url_select;
    public final PBBytesField bytes_icon_url_unselect;
    public final PBBytesField bytes_table_name;
    public final PBStringField trans_info;
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recommend_count = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 130}, new String[]{"uint32_tab_id", "uint32_recommend_count", "bytes_table_name", "bytes_icon_url_select", "bytes_icon_url_unselect", "background_color_select", "background_color_unselect", "trans_info"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, null, null, ""}, oidb_0xc26$TabInfo.class);
    }

    public oidb_0xc26$TabInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_table_name = PBField.initBytes(byteStringMicro);
        this.bytes_icon_url_select = PBField.initBytes(byteStringMicro);
        this.bytes_icon_url_unselect = PBField.initBytes(byteStringMicro);
        this.background_color_select = new oidb_0xc26$Color();
        this.background_color_unselect = new oidb_0xc26$Color();
        this.trans_info = PBField.initString("");
    }
}
