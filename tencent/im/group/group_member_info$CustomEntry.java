package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_member_info$CustomEntry extends MessageMicro<group_member_info$CustomEntry> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_clicked;
    public final PBBytesField str_name;
    public final PBBytesField str_url;
    public final PBBytesField str_value;
    public final PBUInt64Field uint64_report_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"str_name", "str_value", "bool_clicked", "str_url", "uint64_report_id"}, new Object[]{byteStringMicro, byteStringMicro, Boolean.FALSE, byteStringMicro, 0L}, group_member_info$CustomEntry.class);
    }

    public group_member_info$CustomEntry() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_name = PBField.initBytes(byteStringMicro);
        this.str_value = PBField.initBytes(byteStringMicro);
        this.bool_clicked = PBField.initBool(false);
        this.str_url = PBField.initBytes(byteStringMicro);
        this.uint64_report_id = PBField.initUInt64(0L);
    }
}
