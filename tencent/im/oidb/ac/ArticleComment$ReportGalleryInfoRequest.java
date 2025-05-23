package tencent.im.oidb.ac;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$ReportGalleryInfoRequest extends MessageMicro<ArticleComment$ReportGalleryInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_url;
    public final PBUInt32Field browse_time;
    public final PBUInt32Field client_ip;
    public final PBBytesField echo_info;
    public final PBUInt32Field is_qq;

    /* renamed from: mv, reason: collision with root package name */
    public final PBBytesField f435964mv;
    public final PBBytesField network;

    /* renamed from: os, reason: collision with root package name */
    public final PBBytesField f435965os;
    public final PBUInt32Field recommend_index;
    public final PBRepeatMessageField<ArticleComment$RecommendInfo> recommend_info;
    public final PBBytesField rowkey;
    public final PBUInt32Field site_id;
    public final PBBytesField subv;

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt32Field f435966ts;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBUInt32Field article_id = PBField.initUInt32(0);

    static {
        String[] strArr = {"uin", IPublicAccountBrowser.KEY_PUB_UIN, AppConstants.Key.SHARE_REQ_ARTICLE_ID, "article_url", "is_qq", "os", QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_TEMPLT_ID_FOR_SHARE, "subv", "network", "rowkey", "ts", "site_id", "recommend_index", "echo_info", "client_ip", "browse_time", "recommend_info"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 58, 66, 74, 82, 88, 96, 104, 114, 120, 128, 138}, strArr, new Object[]{0L, 0L, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, 0, 0, null}, ArticleComment$ReportGalleryInfoRequest.class);
    }

    public ArticleComment$ReportGalleryInfoRequest() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.article_url = PBField.initBytes(byteStringMicro);
        this.is_qq = PBField.initUInt32(0);
        this.f435965os = PBField.initBytes(byteStringMicro);
        this.f435964mv = PBField.initBytes(byteStringMicro);
        this.subv = PBField.initBytes(byteStringMicro);
        this.network = PBField.initBytes(byteStringMicro);
        this.rowkey = PBField.initBytes(byteStringMicro);
        this.f435966ts = PBField.initUInt32(0);
        this.site_id = PBField.initUInt32(0);
        this.recommend_index = PBField.initUInt32(0);
        this.echo_info = PBField.initBytes(byteStringMicro);
        this.client_ip = PBField.initUInt32(0);
        this.browse_time = PBField.initUInt32(0);
        this.recommend_info = PBField.initRepeatMessage(ArticleComment$RecommendInfo.class);
    }
}
