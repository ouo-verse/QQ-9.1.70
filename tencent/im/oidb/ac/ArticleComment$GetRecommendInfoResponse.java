package tencent.im.oidb.ac;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$GetRecommendInfoResponse extends MessageMicro<ArticleComment$GetRecommendInfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ret", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME}, new Object[]{null, null}, ArticleComment$GetRecommendInfoResponse.class);
    public ArticleComment$RetInfo ret = new ArticleComment$RetInfo();
    public final PBRepeatMessageField<ArticleComment$RecommendItemInfo> item = PBField.initRepeatMessage(ArticleComment$RecommendItemInfo.class);
}
