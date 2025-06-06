package tencent.im.oidb.cmd0xe3b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe3b$RspBody extends MessageMicro<oidb_0xe3b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie_for_req_type_1;
    public final PBBytesField bytes_cookie_for_req_type_2;
    public final PBBytesField bytes_graybar_title;
    public final PBBytesField bytes_wording_for_empty_data;
    public final PBRepeatMessageField<oidb_0xe3b$HighlightTitle> rpt_msg_highlight_title;
    public final PBRepeatMessageField<oidb_0xe3b$RecommendPerson> rpt_msg_person;
    public final PBUInt32Field uint32_graybar_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66}, new String[]{"uint32_graybar_type", "bytes_graybar_title", "rpt_msg_highlight_title", "uint32_sub_id", "rpt_msg_person", "bytes_cookie_for_req_type_1", "bytes_cookie_for_req_type_2", "bytes_wording_for_empty_data"}, new Object[]{0, byteStringMicro, null, 0, null, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0xe3b$RspBody.class);
    }

    public oidb_0xe3b$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_graybar_title = PBField.initBytes(byteStringMicro);
        this.rpt_msg_highlight_title = PBField.initRepeatMessage(oidb_0xe3b$HighlightTitle.class);
        this.uint32_sub_id = PBField.initUInt32(0);
        this.rpt_msg_person = PBField.initRepeatMessage(oidb_0xe3b$RecommendPerson.class);
        this.bytes_cookie_for_req_type_1 = PBField.initBytes(byteStringMicro);
        this.bytes_cookie_for_req_type_2 = PBField.initBytes(byteStringMicro);
        this.bytes_wording_for_empty_data = PBField.initBytes(byteStringMicro);
    }
}
