package tencent.im.oidb.cmd0xf24;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf24$RspBody extends MessageMicro<oidb_cmd0xf24$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 56, 66, 74, 80, 90, 98, 106}, new String[]{"rowkey", AppConstants.Key.SHARE_REQ_ARTICLE_ID, "title", "cover_image_url", "read_count", "publish_time", IPublicAccountBrowser.KEY_PUB_UIN, "account_avatar_url", "account_name", "over_length", "json_article_content", "json_extend_info", ComicCancelRedPointPopItemData.JSON_KEY_TAGS}, new Object[]{"", 0L, "", "", 0L, 0L, 0L, "", "", Boolean.FALSE, "", "", ""}, oidb_cmd0xf24$RspBody.class);
    public final PBStringField rowkey = PBField.initString("");
    public final PBUInt64Field article_id = PBField.initUInt64(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField cover_image_url = PBField.initString("");
    public final PBUInt64Field read_count = PBField.initUInt64(0);
    public final PBInt64Field publish_time = PBField.initInt64(0);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBStringField account_avatar_url = PBField.initString("");
    public final PBStringField account_name = PBField.initString("");
    public final PBBoolField over_length = PBField.initBool(false);
    public final PBStringField json_article_content = PBField.initString("");
    public final PBStringField json_extend_info = PBField.initString("");
    public final PBStringField tags = PBField.initString("");
}
