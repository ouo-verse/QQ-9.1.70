package tencent.im.qqwallet;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetRecommendWords$ClassifyItem extends MessageMicro<GetRecommendWords$ClassifyItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME}, new Object[]{""}, GetRecommendWords$ClassifyItem.class);
    public final PBStringField item = PBField.initString("");
}
