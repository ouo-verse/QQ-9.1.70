package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicTabSearch$RspBody extends MessageMicro<DynamicTabSearch$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie;
    public final PBUInt32Field dont_need_merge;
    public final PBBytesField extension;
    public final PBRepeatMessageField<DynamicTabSearch$SubHotWord> hot_words;
    public final PBBytesField search_ver;
    public final PBBytesField sub_hot_top_wording;
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBStringField error_msg = PBField.initString("");
    public final PBRepeatMessageField<DynamicSearch$ResultItemGroup> item_groups = PBField.initRepeatMessage(DynamicSearch$ResultItemGroup.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);

    static {
        String[] strArr = {"result_code", "error_msg", "item_groups", "is_end", "cookie", "search_ver", "hot_words", "sub_hot_top_wording", "dont_need_merge", MimeTypeParser.ATTR_EXTENSION};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66, 72, 810}, strArr, new Object[]{0, "", null, 0, byteStringMicro, byteStringMicro, null, byteStringMicro, 0, byteStringMicro}, DynamicTabSearch$RspBody.class);
    }

    public DynamicTabSearch$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cookie = PBField.initBytes(byteStringMicro);
        this.search_ver = PBField.initBytes(byteStringMicro);
        this.hot_words = PBField.initRepeatMessage(DynamicTabSearch$SubHotWord.class);
        this.sub_hot_top_wording = PBField.initBytes(byteStringMicro);
        this.dont_need_merge = PBField.initUInt32(0);
        this.extension = PBField.initBytes(byteStringMicro);
    }
}
