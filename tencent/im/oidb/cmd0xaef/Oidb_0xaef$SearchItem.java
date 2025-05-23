package tencent.im.oidb.cmd0xaef;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import tencent.im.oidb.cmd0xae9.group_online_docs$DocInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xaef$SearchItem extends MessageMicro<Oidb_0xaef$SearchItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"doc_info", "match_word"}, new Object[]{null, ByteStringMicro.EMPTY}, Oidb_0xaef$SearchItem.class);
    public group_online_docs$DocInfo doc_info = new group_online_docs$DocInfo();
    public final PBRepeatField<ByteStringMicro> match_word = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
