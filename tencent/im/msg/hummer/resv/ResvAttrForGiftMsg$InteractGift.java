package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ResvAttrForGiftMsg$InteractGift extends MessageMicro<ResvAttrForGiftMsg$InteractGift> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_interact_id"}, new Object[]{ByteStringMicro.EMPTY}, ResvAttrForGiftMsg$InteractGift.class);
    public final PBBytesField bytes_interact_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
