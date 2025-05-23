package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicTabSearch$SubHotWord extends MessageMicro<DynamicTabSearch$SubHotWord> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField search_word;
    public final PBBytesField show_word;
    public final PBUInt32Field word_id = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"word_id", "show_word", "search_word"}, new Object[]{0, byteStringMicro, byteStringMicro}, DynamicTabSearch$SubHotWord.class);
    }

    public DynamicTabSearch$SubHotWord() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.show_word = PBField.initBytes(byteStringMicro);
        this.search_word = PBField.initBytes(byteStringMicro);
    }
}
