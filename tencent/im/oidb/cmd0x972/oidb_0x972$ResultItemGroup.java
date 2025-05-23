package tencent.im.oidb.cmd0x972;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x972$ResultItemGroup extends MessageMicro<oidb_0x972$ResultItemGroup> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field group_mask = PBField.initUInt64(0);
    public final PBBytesField group_name;
    public final PBBytesField more_name;
    public final PBBytesField more_url;
    public final PBRepeatMessageField<oidb_0x972$ResultItem> result_items;
    public final PBRepeatField<ByteStringMicro> rpt_highlight_words;
    public final PBUInt64Field total_result_count;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 8002}, new String[]{"group_mask", "group_name", "result_items", "total_result_count", "more_url", "more_name", "rpt_highlight_words"}, new Object[]{0L, byteStringMicro, null, 0L, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0x972$ResultItemGroup.class);
    }

    public oidb_0x972$ResultItemGroup() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.group_name = PBField.initBytes(byteStringMicro);
        this.result_items = PBField.initRepeatMessage(oidb_0x972$ResultItem.class);
        this.total_result_count = PBField.initUInt64(0L);
        this.more_url = PBField.initBytes(byteStringMicro);
        this.more_name = PBField.initBytes(byteStringMicro);
        this.rpt_highlight_words = PBField.initRepeat(PBBytesField.__repeatHelper__);
    }
}
