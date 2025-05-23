package tencent.im.oidb.cmd0x972;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x972$ResultItem extends MessageMicro<oidb_0x972$ResultItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField extension;
    public final PBUInt64Field group_mask;
    public final PBBytesField jmp_url;
    public final PBBytesField name;
    public final PBBytesField pic_url;
    public final PBBytesField result_id;
    public final PBRepeatMessageField<oidb_0x972$Meaning> rpt_meaning;
    public final PBBytesField word;

    static {
        String[] strArr = {"result_id", "name", "pic_url", "jmp_url", "word", MimeTypeParser.ATTR_EXTENSION, "rpt_meaning", "group_mask"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, null, 0L}, oidb_0x972$ResultItem.class);
    }

    public oidb_0x972$ResultItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.result_id = PBField.initBytes(byteStringMicro);
        this.name = PBField.initBytes(byteStringMicro);
        this.pic_url = PBField.initBytes(byteStringMicro);
        this.jmp_url = PBField.initBytes(byteStringMicro);
        this.word = PBField.initBytes(byteStringMicro);
        this.extension = PBField.initBytes(byteStringMicro);
        this.rpt_meaning = PBField.initRepeatMessage(oidb_0x972$Meaning.class);
        this.group_mask = PBField.initUInt64(0L);
    }
}
