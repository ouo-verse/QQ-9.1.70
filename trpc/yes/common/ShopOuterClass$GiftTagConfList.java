package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class ShopOuterClass$GiftTagConfList extends MessageMicro<ShopOuterClass$GiftTagConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, ShopOuterClass$GiftTagConfList.class);
    public final PBRepeatMessageField<ShopOuterClass$GiftTagConf> data = PBField.initRepeatMessage(ShopOuterClass$GiftTagConf.class);
}
