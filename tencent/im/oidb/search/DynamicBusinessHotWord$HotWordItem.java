package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicBusinessHotWord$HotWordItem extends MessageMicro<DynamicBusinessHotWord$HotWordItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField word;
    public final PBBytesField word_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"word_id", "word"}, new Object[]{byteStringMicro, byteStringMicro}, DynamicBusinessHotWord$HotWordItem.class);
    }

    public DynamicBusinessHotWord$HotWordItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.word_id = PBField.initBytes(byteStringMicro);
        this.word = PBField.initBytes(byteStringMicro);
    }
}
