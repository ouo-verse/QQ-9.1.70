package tencent.im.oidb.cmd0x9ab;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9ab$TabItem extends MessageMicro<oidb_0x9ab$TabItem> {
    public static final int BYT_TAB_URL_FIELD_NUMBER = 3;
    public static final int BYT_TAB_WORDING_FIELD_NUMBER = 2;
    public static final int UINT32_STATUS_FLAG_FIELD_NUMBER = 4;
    public static final int UINT32_TAB_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField byt_tab_url;
    public final PBBytesField byt_tab_wording;
    public final PBUInt32Field uint32_status_flag;
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_tab_id", "byt_tab_wording", "byt_tab_url", "uint32_status_flag"}, new Object[]{0, byteStringMicro, byteStringMicro, 0}, oidb_0x9ab$TabItem.class);
    }

    public oidb_0x9ab$TabItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.byt_tab_wording = PBField.initBytes(byteStringMicro);
        this.byt_tab_url = PBField.initBytes(byteStringMicro);
        this.uint32_status_flag = PBField.initUInt32(0);
    }
}
