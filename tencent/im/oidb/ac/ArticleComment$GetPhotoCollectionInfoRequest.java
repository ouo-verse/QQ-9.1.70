package tencent.im.oidb.ac;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class ArticleComment$GetPhotoCollectionInfoRequest extends MessageMicro<ArticleComment$GetPhotoCollectionInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48}, new String[]{"versionInfo", "cuin", AppConstants.Key.SHARE_REQ_ARTICLE_ID, IPublicAccountImageCollectionMainActivity.RECOMMEND_SOURCE, IPublicAccountImageCollectionMainActivity.RECOMMEND_POSITION, IPublicAccountImageCollectionMainActivity.CLICK_SOURCE}, new Object[]{"", 0L, ByteStringMicro.EMPTY, "", 0, 0}, ArticleComment$GetPhotoCollectionInfoRequest.class);
    public final PBStringField versionInfo = PBField.initString("");
    public final PBUInt64Field cuin = PBField.initUInt64(0);
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField recommend_source = PBField.initString("");
    public final PBUInt32Field recommend_position = PBField.initUInt32(0);
    public final PBUInt32Field click_source = PBField.initUInt32(0);
}
