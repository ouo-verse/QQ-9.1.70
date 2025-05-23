package tencent.im.oidb.ac;

import com.qzone.widget.v;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class ArticleComment$GetPhotoCollectionInfoResponse extends MessageMicro<ArticleComment$GetPhotoCollectionInfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_img_url;
    public final PBBytesField article_share_url;
    public final PBBytesField article_title;
    public final PBBytesField comment_url;
    public final PBUInt32Field enable_comment;
    public ArticleComment$PhotoFirstItemInfo firstItem;
    public final PBUInt64Field puin;
    public ArticleComment$RetInfo ret = new ArticleComment$RetInfo();
    public final PBRepeatMessageField<ArticleComment$PhotoItemInfo> item = PBField.initRepeatMessage(ArticleComment$PhotoItemInfo.class);

    static {
        String[] strArr = {"ret", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "article_share_url", IPublicAccountBrowser.KEY_PUB_UIN, "article_img_url", "article_title", "enable_comment", v.COLUMN_COMMENT_URL, "firstItem"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 56, 66, 74}, strArr, new Object[]{null, null, byteStringMicro, 0L, byteStringMicro, byteStringMicro, 0, byteStringMicro, null}, ArticleComment$GetPhotoCollectionInfoResponse.class);
    }

    public ArticleComment$GetPhotoCollectionInfoResponse() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.article_share_url = PBField.initBytes(byteStringMicro);
        this.puin = PBField.initUInt64(0L);
        this.article_img_url = PBField.initBytes(byteStringMicro);
        this.article_title = PBField.initBytes(byteStringMicro);
        this.enable_comment = PBField.initUInt32(0);
        this.comment_url = PBField.initBytes(byteStringMicro);
        this.firstItem = new ArticleComment$PhotoFirstItemInfo();
    }
}
