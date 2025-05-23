package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$NewDnaInfo extends MessageMicro<oidb_0xcf4$NewDnaInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover_url;
    public final PBBytesField bytes_jump_minapp_url;
    public final PBBytesField bytes_jump_url;
    public final PBBytesField bytes_title;
    public final PBEnumField eDnaType = PBField.initEnum(1);
    public final PBRepeatMessageField<oidb_0xcf4$DnaDetail> rpt_detail;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"eDnaType", "bytes_title", "bytes_jump_url", "rpt_detail", "bytes_cover_url", "bytes_jump_minapp_url"}, new Object[]{1, byteStringMicro, byteStringMicro, null, byteStringMicro, byteStringMicro}, oidb_0xcf4$NewDnaInfo.class);
    }

    public oidb_0xcf4$NewDnaInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.bytes_jump_url = PBField.initBytes(byteStringMicro);
        this.rpt_detail = PBField.initRepeatMessage(oidb_0xcf4$DnaDetail.class);
        this.bytes_cover_url = PBField.initBytes(byteStringMicro);
        this.bytes_jump_minapp_url = PBField.initBytes(byteStringMicro);
    }
}
