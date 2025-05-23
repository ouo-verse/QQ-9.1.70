package unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UnifySearchCommon$Meaning extends MessageMicro<UnifySearchCommon$Meaning> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"words", "eflag"}, new Object[]{ByteStringMicro.EMPTY, 0}, UnifySearchCommon$Meaning.class);
    public final PBBytesField words = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field eflag = PBField.initUInt32(0);
}
