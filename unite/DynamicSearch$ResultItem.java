package unite;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class DynamicSearch$ResultItem extends MessageMicro<DynamicSearch$ResultItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField extension;
    public final PBUInt64Field group_mask;
    public final PBBytesField jmp_url;
    public final PBBytesField layout_content;
    public final PBUInt32Field layout_id;
    public final PBBytesField name;
    public final PBBytesField pic_url;
    public final PBBytesField report_ext_data;
    public final PBBytesField result_id;
    public final PBUInt64Field result_item_type;
    public final PBRepeatMessageField<DynamicSearch$Meaning> rpt_meaning;
    public final PBUInt32Field seporator_type;
    public final PBRepeatMessageField<DynamicSearch$SubItem> sub_item_list;
    public final PBRepeatMessageField<DynamicSearch$ResultItem> sub_result_items;
    public final PBBytesField word;

    static {
        String[] strArr = {"result_id", "name", "pic_url", "jmp_url", "word", MimeTypeParser.ATTR_EXTENSION, "rpt_meaning", "group_mask", "sub_item_list", "layout_id", "layout_content", "sub_result_items", "result_item_type", "seporator_type", "report_ext_data"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 74, 80, 90, 170, 176, 184, 194}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, null, 0L, null, 0, byteStringMicro, null, 0L, 0, byteStringMicro}, DynamicSearch$ResultItem.class);
    }

    public DynamicSearch$ResultItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.result_id = PBField.initBytes(byteStringMicro);
        this.name = PBField.initBytes(byteStringMicro);
        this.pic_url = PBField.initBytes(byteStringMicro);
        this.jmp_url = PBField.initBytes(byteStringMicro);
        this.word = PBField.initBytes(byteStringMicro);
        this.extension = PBField.initBytes(byteStringMicro);
        this.rpt_meaning = PBField.initRepeatMessage(DynamicSearch$Meaning.class);
        this.group_mask = PBField.initUInt64(0L);
        this.sub_item_list = PBField.initRepeatMessage(DynamicSearch$SubItem.class);
        this.layout_id = PBField.initUInt32(0);
        this.layout_content = PBField.initBytes(byteStringMicro);
        this.sub_result_items = PBField.initRepeatMessage(DynamicSearch$ResultItem.class);
        this.result_item_type = PBField.initUInt64(0L);
        this.seporator_type = PBField.initUInt32(0);
        this.report_ext_data = PBField.initBytes(byteStringMicro);
    }
}
