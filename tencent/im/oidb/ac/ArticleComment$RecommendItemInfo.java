package tencent.im.oidb.ac;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$RecommendItemInfo extends MessageMicro<ArticleComment$RecommendItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_id;
    public final PBBytesField recommend_source;
    public final PBBytesField title;
    public final PBBytesField url;

    static {
        String[] strArr = {"url", "title", IPublicAccountImageCollectionMainActivity.RECOMMEND_SOURCE, AppConstants.Key.SHARE_REQ_ARTICLE_ID};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, ArticleComment$RecommendItemInfo.class);
    }

    public ArticleComment$RecommendItemInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.url = PBField.initBytes(byteStringMicro);
        this.title = PBField.initBytes(byteStringMicro);
        this.recommend_source = PBField.initBytes(byteStringMicro);
        this.article_id = PBField.initBytes(byteStringMicro);
    }
}
