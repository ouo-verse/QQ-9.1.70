package v81;

import android.text.TextUtils;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ar.ARLBSHandler;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCommonPb$ARCloudRecogReq;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCommonPb$ARCloudRecogRsp;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCommonPb$ARFileReqInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARFaceRecogInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARFaceRecogRes;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARFaceRecogResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARMarkerRecogInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARMarkerRecogResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARObjectClassifyInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARObjectClassifyResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$AROcrInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$AROcrResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARSceneClassifyInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARSceneClassifyResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ARWordDetectInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$FaceRect;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ImageARSearchRes;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ImageARTag;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ImageTranslateReqInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ImgRetrievalInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$ImgRetrievalResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$QuestionRes;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$SearchQuestionInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$SearchQuestionResult;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$StarInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalComm$OD_BBox;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic$IRLogicRsp;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic$LabelSource;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic$RetrievalClassInfo;
import com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalLogic$RetrievalItem;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch$JdSearchReq;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr$YoutuOcrReq;
import com.tencent.mobileqq.ar.arengine.ac;
import com.tencent.mobileqq.ar.arengine.al;
import com.tencent.mobileqq.ar.arengine.d;
import com.tencent.mobileqq.ar.arengine.g;
import com.tencent.mobileqq.ar.arengine.h;
import com.tencent.mobileqq.ar.arengine.i;
import com.tencent.mobileqq.ar.arengine.m;
import com.tencent.mobileqq.ar.arengine.o;
import com.tencent.mobileqq.ar.arengine.q;
import com.tencent.mobileqq.ar.arengine.s;
import com.tencent.mobileqq.ar.arengine.t;
import com.tencent.mobileqq.ar.arengine.w;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected AppInterface f441222a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<e> f441223b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f441224c;

    /* renamed from: d, reason: collision with root package name */
    private Object f441225d;

    /* renamed from: e, reason: collision with root package name */
    private String f441226e;

    /* renamed from: f, reason: collision with root package name */
    private d f441227f;

    /* renamed from: g, reason: collision with root package name */
    com.tencent.mobileqq.ar.d f441228g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: v81.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C11401a extends com.tencent.mobileqq.ar.d {
        C11401a() {
        }

        @Override // com.tencent.mobileqq.ar.d
        public void a(com.tencent.mobileqq.ar.arengine.b bVar) {
            if (a.this.f441227f != null) {
                a.this.f441227f.a(bVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
        void a(int i3, String str, m mVar);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface d {
        void a(com.tencent.mobileqq.ar.arengine.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class e {

        /* renamed from: b, reason: collision with root package name */
        q f441234b;

        /* renamed from: a, reason: collision with root package name */
        String f441233a = "";

        /* renamed from: c, reason: collision with root package name */
        Transaction f441235c = null;

        /* renamed from: d, reason: collision with root package name */
        c f441236d = null;
    }

    public a(AppInterface appInterface) {
        this(appInterface, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m f(byte[] bArr, q qVar) {
        List<ImageRetrievalLogic$RetrievalClassInfo> list;
        double d16;
        m mVar = new m();
        ARCloudRecogCommonPb$ARCloudRecogRsp aRCloudRecogCommonPb$ARCloudRecogRsp = new ARCloudRecogCommonPb$ARCloudRecogRsp();
        try {
            aRCloudRecogCommonPb$ARCloudRecogRsp.mergeFrom(bArr);
            mVar.f198203a = aRCloudRecogCommonPb$ARCloudRecogRsp.str_session_id.has() ? aRCloudRecogCommonPb$ARCloudRecogRsp.str_session_id.get() : "";
            mVar.f198204b = aRCloudRecogCommonPb$ARCloudRecogRsp.uin64_req_recog_type.has() ? aRCloudRecogCommonPb$ARCloudRecogRsp.uin64_req_recog_type.get() : 0L;
            mVar.f198205c = aRCloudRecogCommonPb$ARCloudRecogRsp.uin32_business_type.has() ? aRCloudRecogCommonPb$ARCloudRecogRsp.uin32_business_type.get() : -1;
            if (aRCloudRecogCommonPb$ARCloudRecogRsp.msg_ar_marker_recog_result.has()) {
                com.tencent.mobileqq.ar.arengine.d dVar = new com.tencent.mobileqq.ar.arengine.d();
                ARCloudRecogCustomPb$ARMarkerRecogResult aRCloudRecogCustomPb$ARMarkerRecogResult = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_ar_marker_recog_result.get();
                dVar.f198155c = aRCloudRecogCustomPb$ARMarkerRecogResult.image_ar_search_errorcode.has() ? aRCloudRecogCustomPb$ARMarkerRecogResult.image_ar_search_errorcode.get() : -1;
                dVar.f198156d = aRCloudRecogCustomPb$ARMarkerRecogResult.image_ar_search_errormsg.has() ? aRCloudRecogCustomPb$ARMarkerRecogResult.image_ar_search_errormsg.get() : "";
                if (aRCloudRecogCustomPb$ARMarkerRecogResult.image_ar_search_res.has()) {
                    ARCloudRecogCustomPb$ImageARSearchRes aRCloudRecogCustomPb$ImageARSearchRes = aRCloudRecogCustomPb$ARMarkerRecogResult.image_ar_search_res.get();
                    dVar.f198158f = aRCloudRecogCustomPb$ImageARSearchRes.errorcode.has() ? aRCloudRecogCustomPb$ImageARSearchRes.errorcode.get() : -1;
                    dVar.f198159g = aRCloudRecogCustomPb$ImageARSearchRes.errormsg.has() ? aRCloudRecogCustomPb$ImageARSearchRes.errormsg.get() : "";
                    dVar.f198160h = aRCloudRecogCustomPb$ImageARSearchRes.session_id.has() ? aRCloudRecogCustomPb$ImageARSearchRes.session_id.get() : "";
                    if (aRCloudRecogCustomPb$ImageARSearchRes.tags.has() && aRCloudRecogCustomPb$ImageARSearchRes.tags.size() > 0) {
                        int size = aRCloudRecogCustomPb$ImageARSearchRes.tags.size();
                        dVar.f198161i = new d.a[size];
                        for (int i3 = 0; i3 < size; i3++) {
                            d.a aVar = new d.a();
                            ARCloudRecogCustomPb$ImageARTag aRCloudRecogCustomPb$ImageARTag = aRCloudRecogCustomPb$ImageARSearchRes.tags.get(i3);
                            aVar.f198165a = aRCloudRecogCustomPb$ImageARTag.image_id.has() ? aRCloudRecogCustomPb$ImageARTag.image_id.get() : "";
                            aVar.f198166b = aRCloudRecogCustomPb$ImageARTag.tag_name.has() ? aRCloudRecogCustomPb$ImageARTag.tag_name.get() : "";
                            aVar.f198167c = aRCloudRecogCustomPb$ImageARTag.tag_confidence.has() ? aRCloudRecogCustomPb$ImageARTag.tag_confidence.get() : 0;
                            aVar.f198168d = aRCloudRecogCustomPb$ImageARTag.tag_confidence_f.has() ? aRCloudRecogCustomPb$ImageARTag.tag_confidence_f.get() : 0.0f;
                            aVar.f198169e = aRCloudRecogCustomPb$ImageARTag.need_check_lbs.has() ? aRCloudRecogCustomPb$ImageARTag.need_check_lbs.get() : 0;
                            aVar.f198170f = aRCloudRecogCustomPb$ImageARTag.cdb_errorcode.has() ? aRCloudRecogCustomPb$ImageARTag.cdb_errorcode.get() : -1;
                            aVar.f198171g = aRCloudRecogCustomPb$ImageARTag.cdb_res.has() ? aRCloudRecogCustomPb$ImageARTag.cdb_res.get().toByteArray() : null;
                            dVar.f198161i[i3] = aVar;
                        }
                        if (size > 0) {
                            dVar.f198216a = dVar.f198161i[0].f198169e == 1;
                        }
                    } else {
                        dVar.f198161i = null;
                    }
                    dVar.f198162j = aRCloudRecogCustomPb$ImageARSearchRes.time_ms.has() ? aRCloudRecogCustomPb$ImageARSearchRes.time_ms.get() : 0;
                    dVar.f198163k = aRCloudRecogCustomPb$ImageARSearchRes.score.has() ? aRCloudRecogCustomPb$ImageARSearchRes.score.get() : 0;
                    dVar.f198164l = aRCloudRecogCustomPb$ImageARSearchRes.kpt_num.has() ? aRCloudRecogCustomPb$ImageARSearchRes.kpt_num.get() : 0;
                } else {
                    dVar.f198158f = -1;
                    dVar.f198159g = "";
                    dVar.f198160h = "";
                    dVar.f198161i = null;
                    dVar.f198162j = 0;
                    dVar.f198163k = 0;
                    dVar.f198164l = 0;
                }
                mVar.f198206d = dVar;
            } else {
                mVar.f198206d = null;
            }
            if (aRCloudRecogCommonPb$ARCloudRecogRsp.msg_ar_object_classify_result.has()) {
                g gVar = new g();
                ARCloudRecogCustomPb$ARObjectClassifyResult aRCloudRecogCustomPb$ARObjectClassifyResult = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_ar_object_classify_result.get();
                gVar.f198174c = aRCloudRecogCustomPb$ARObjectClassifyResult.ar_object_classify_errorcode.has() ? aRCloudRecogCustomPb$ARObjectClassifyResult.ar_object_classify_errorcode.get() : -1;
                gVar.f198175d = aRCloudRecogCustomPb$ARObjectClassifyResult.ar_object_classify_errormsg.has() ? aRCloudRecogCustomPb$ARObjectClassifyResult.ar_object_classify_errormsg.get() : "";
                if (aRCloudRecogCustomPb$ARObjectClassifyResult.image_ar_search_res.has()) {
                    ARCloudRecogCustomPb$ImageARSearchRes aRCloudRecogCustomPb$ImageARSearchRes2 = aRCloudRecogCustomPb$ARObjectClassifyResult.image_ar_search_res.get();
                    gVar.f198177f = aRCloudRecogCustomPb$ImageARSearchRes2.errorcode.has() ? aRCloudRecogCustomPb$ImageARSearchRes2.errorcode.get() : -1;
                    gVar.f198178g = aRCloudRecogCustomPb$ImageARSearchRes2.errormsg.has() ? aRCloudRecogCustomPb$ImageARSearchRes2.errormsg.get() : "";
                    gVar.f198179h = aRCloudRecogCustomPb$ImageARSearchRes2.session_id.has() ? aRCloudRecogCustomPb$ImageARSearchRes2.session_id.get() : "";
                    if (aRCloudRecogCustomPb$ImageARSearchRes2.tags.has() && aRCloudRecogCustomPb$ImageARSearchRes2.tags.size() > 0) {
                        int size2 = aRCloudRecogCustomPb$ImageARSearchRes2.tags.size();
                        gVar.f198180i = new g.a[size2];
                        for (int i16 = 0; i16 < size2; i16++) {
                            g.a aVar2 = new g.a();
                            ARCloudRecogCustomPb$ImageARTag aRCloudRecogCustomPb$ImageARTag2 = aRCloudRecogCustomPb$ImageARSearchRes2.tags.get(i16);
                            aVar2.f198184a = aRCloudRecogCustomPb$ImageARTag2.image_id.has() ? aRCloudRecogCustomPb$ImageARTag2.image_id.get() : "";
                            aVar2.f198185b = aRCloudRecogCustomPb$ImageARTag2.tag_name.has() ? aRCloudRecogCustomPb$ImageARTag2.tag_name.get() : "";
                            aVar2.f198186c = aRCloudRecogCustomPb$ImageARTag2.tag_confidence.has() ? aRCloudRecogCustomPb$ImageARTag2.tag_confidence.get() : 0;
                            aVar2.f198187d = aRCloudRecogCustomPb$ImageARTag2.tag_confidence_f.has() ? aRCloudRecogCustomPb$ImageARTag2.tag_confidence_f.get() : 0.0f;
                            aVar2.f198188e = aRCloudRecogCustomPb$ImageARTag2.need_check_lbs.has() ? aRCloudRecogCustomPb$ImageARTag2.need_check_lbs.get() : 0;
                            aVar2.f198189f = aRCloudRecogCustomPb$ImageARTag2.cdb_errorcode.has() ? aRCloudRecogCustomPb$ImageARTag2.cdb_errorcode.get() : -1;
                            aVar2.f198190g = aRCloudRecogCustomPb$ImageARTag2.cdb_res.has() ? aRCloudRecogCustomPb$ImageARTag2.cdb_res.get().toByteArray() : null;
                            gVar.f198180i[i16] = aVar2;
                        }
                        if (size2 > 0) {
                            gVar.f198216a = gVar.f198180i[0].f198188e == 1;
                        }
                    } else {
                        gVar.f198180i = null;
                    }
                    gVar.f198181j = aRCloudRecogCustomPb$ImageARSearchRes2.time_ms.has() ? aRCloudRecogCustomPb$ImageARSearchRes2.time_ms.get() : 0;
                    gVar.f198182k = aRCloudRecogCustomPb$ImageARSearchRes2.score.has() ? aRCloudRecogCustomPb$ImageARSearchRes2.score.get() : 0;
                    gVar.f198183l = aRCloudRecogCustomPb$ImageARSearchRes2.kpt_num.has() ? aRCloudRecogCustomPb$ImageARSearchRes2.kpt_num.get() : 0;
                } else {
                    gVar.f198177f = -1;
                    gVar.f198178g = "";
                    gVar.f198179h = "";
                    gVar.f198180i = null;
                    gVar.f198181j = 0;
                    gVar.f198182k = 0;
                    gVar.f198183l = 0;
                }
                mVar.f198207e = gVar;
            } else {
                mVar.f198207e = null;
            }
            mVar.f198212j = null;
            if (aRCloudRecogCommonPb$ARCloudRecogRsp.msg_img_retrieval_result.has()) {
                ac acVar = new ac();
                acVar.f197993g = System.currentTimeMillis();
                ARCloudRecogCustomPb$ImgRetrievalResult aRCloudRecogCustomPb$ImgRetrievalResult = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_img_retrieval_result.get();
                acVar.f197991e = aRCloudRecogCustomPb$ImgRetrievalResult.errorcode.has() ? aRCloudRecogCustomPb$ImgRetrievalResult.errorcode.get() : -1;
                acVar.f197992f = aRCloudRecogCustomPb$ImgRetrievalResult.errormsg.has() ? aRCloudRecogCustomPb$ImgRetrievalResult.errormsg.get() : "";
                if (aRCloudRecogCustomPb$ImgRetrievalResult.jd_search_rsp.has()) {
                    acVar.f198000n = ac.m(aRCloudRecogCustomPb$ImgRetrievalResult.jd_search_rsp.get());
                }
                if (aRCloudRecogCustomPb$ImgRetrievalResult.msg_ir_logic_rsp.has()) {
                    ImageRetrievalLogic$IRLogicRsp imageRetrievalLogic$IRLogicRsp = aRCloudRecogCustomPb$ImgRetrievalResult.msg_ir_logic_rsp.get();
                    acVar.f197994h = imageRetrievalLogic$IRLogicRsp.iRetCode.has() ? imageRetrievalLogic$IRLogicRsp.iRetCode.get() : -1;
                    acVar.f197995i = imageRetrievalLogic$IRLogicRsp.sMsg.has() ? imageRetrievalLogic$IRLogicRsp.sMsg.get() : "";
                    acVar.f197997k = imageRetrievalLogic$IRLogicRsp.iBusiness.has() ? imageRetrievalLogic$IRLogicRsp.iBusiness.get() : -1;
                    acVar.f197998l = imageRetrievalLogic$IRLogicRsp.sKey.has() ? imageRetrievalLogic$IRLogicRsp.sKey.get() : "";
                    acVar.f197999m = null;
                    if (imageRetrievalLogic$IRLogicRsp.stBBox.has()) {
                        acVar.f197999m = new ac.f();
                        ImageRetrievalComm$OD_BBox imageRetrievalComm$OD_BBox = imageRetrievalLogic$IRLogicRsp.stBBox.get();
                        acVar.f197999m.f198037a = imageRetrievalComm$OD_BBox.xmin.has() ? imageRetrievalComm$OD_BBox.xmin.get() : 0;
                        acVar.f197999m.f198038b = imageRetrievalComm$OD_BBox.xmax.has() ? imageRetrievalComm$OD_BBox.xmax.get() : 0;
                        acVar.f197999m.f198039c = imageRetrievalComm$OD_BBox.ymin.has() ? imageRetrievalComm$OD_BBox.ymin.get() : 0;
                        acVar.f197999m.f198040d = imageRetrievalComm$OD_BBox.ymax.has() ? imageRetrievalComm$OD_BBox.ymax.get() : 0;
                        acVar.f197999m.f198041e = imageRetrievalComm$OD_BBox.fScore.has() ? imageRetrievalComm$OD_BBox.fScore.get() : 0.0f;
                        acVar.f197999m.f198042f = imageRetrievalComm$OD_BBox.iLabelID.has() ? imageRetrievalComm$OD_BBox.iLabelID.get() : 0;
                        if (QLog.isColorLevel()) {
                            QLog.d("AREngine_ARCloudFileUpload", 2, "[MIGObjectclassifyResult \u77e9\u5f62\u533a\u57df\u539f\u59cb\u6570\u636e\u6253\u5370]" + acVar.f197999m.toString());
                        }
                    }
                    if (imageRetrievalLogic$IRLogicRsp.vClassInfo.has() && imageRetrievalLogic$IRLogicRsp.vClassInfo.size() > 0) {
                        int size3 = imageRetrievalLogic$IRLogicRsp.vClassInfo.size();
                        acVar.f197996j = new ac.g[size3];
                        List<ImageRetrievalLogic$RetrievalClassInfo> list2 = imageRetrievalLogic$IRLogicRsp.vClassInfo.get();
                        int i17 = 0;
                        while (i17 < size3) {
                            ImageRetrievalLogic$RetrievalClassInfo imageRetrievalLogic$RetrievalClassInfo = list2.get(i17);
                            ac.g gVar2 = new ac.g();
                            gVar2.f198043a = imageRetrievalLogic$RetrievalClassInfo.iClass.has() ? imageRetrievalLogic$RetrievalClassInfo.iClass.get() : 0;
                            gVar2.f198047e = imageRetrievalLogic$RetrievalClassInfo.iStatus.has() ? imageRetrievalLogic$RetrievalClassInfo.iStatus.get() : 0;
                            if (imageRetrievalLogic$RetrievalClassInfo.dClassProb.has()) {
                                list = list2;
                                d16 = imageRetrievalLogic$RetrievalClassInfo.dClassProb.get();
                            } else {
                                list = list2;
                                d16 = 0.0d;
                            }
                            gVar2.f198045c = d16;
                            gVar2.f198044b = imageRetrievalLogic$RetrievalClassInfo.sClass.has() ? imageRetrievalLogic$RetrievalClassInfo.sClass.get() : "";
                            if (imageRetrievalLogic$RetrievalClassInfo.vItem.has() && imageRetrievalLogic$RetrievalClassInfo.vItem.size() > 0) {
                                gVar2.f198046d = new ac.h[imageRetrievalLogic$RetrievalClassInfo.vItem.size()];
                            }
                            if (imageRetrievalLogic$RetrievalClassInfo.vItem.has() && imageRetrievalLogic$RetrievalClassInfo.vItem.size() > 0) {
                                for (int i18 = 0; i18 < imageRetrievalLogic$RetrievalClassInfo.vItem.size(); i18++) {
                                    ac.h hVar = new ac.h();
                                    ImageRetrievalLogic$RetrievalItem imageRetrievalLogic$RetrievalItem = imageRetrievalLogic$RetrievalClassInfo.vItem.get(i18);
                                    hVar.f198048a = imageRetrievalLogic$RetrievalItem.iClass.has() ? imageRetrievalLogic$RetrievalItem.iClass.get() : 0;
                                    hVar.f198049b = imageRetrievalLogic$RetrievalItem.sClass.has() ? imageRetrievalLogic$RetrievalItem.sClass.get() : "";
                                    hVar.f198050c = imageRetrievalLogic$RetrievalItem.dProb.has() ? imageRetrievalLogic$RetrievalItem.dProb.get() : 0.0d;
                                    hVar.f198051d = imageRetrievalLogic$RetrievalItem.sItemID.has() ? imageRetrievalLogic$RetrievalItem.sItemID.get() : "";
                                    hVar.f198053f = imageRetrievalLogic$RetrievalItem.iSource.has() ? imageRetrievalLogic$RetrievalItem.iSource.get() : 0;
                                    hVar.f198054g = imageRetrievalLogic$RetrievalItem.sPicUrl.has() ? imageRetrievalLogic$RetrievalItem.sPicUrl.get() : "";
                                    hVar.f198055h = imageRetrievalLogic$RetrievalItem.sTitle.has() ? imageRetrievalLogic$RetrievalItem.sTitle.get() : "";
                                    hVar.f198056i = imageRetrievalLogic$RetrievalItem.sWiki.has() ? imageRetrievalLogic$RetrievalItem.sWiki.get() : "";
                                    hVar.f198057j = imageRetrievalLogic$RetrievalItem.sJumpUrl.has() ? imageRetrievalLogic$RetrievalItem.sJumpUrl.get() : "";
                                    hVar.f198058k = imageRetrievalLogic$RetrievalItem.sCdbRes.has() ? imageRetrievalLogic$RetrievalItem.sCdbRes.get().toByteArray() : null;
                                    hVar.f198059l = imageRetrievalLogic$RetrievalItem.iAutoJump.has() && imageRetrievalLogic$RetrievalItem.iAutoJump.get() == 1;
                                    hVar.f198061n = imageRetrievalLogic$RetrievalItem.iNeedCheckLBS.has() ? imageRetrievalLogic$RetrievalItem.iNeedCheckLBS.get() : 0;
                                    hVar.f198062o = imageRetrievalLogic$RetrievalItem.sImageId.has() ? imageRetrievalLogic$RetrievalItem.sImageId.get() : "";
                                    if (imageRetrievalLogic$RetrievalItem.stLabel.has()) {
                                        ImageRetrievalLogic$LabelSource imageRetrievalLogic$LabelSource = imageRetrievalLogic$RetrievalItem.stLabel.get();
                                        hVar.f198052e = new ac.d();
                                        if (imageRetrievalLogic$LabelSource.stLabelComm.has()) {
                                            hVar.f198052e.f198022a = imageRetrievalLogic$LabelSource.stLabelComm.sLabel.has() ? imageRetrievalLogic$LabelSource.stLabelComm.sLabel.get() : "";
                                        }
                                        if (imageRetrievalLogic$LabelSource.stLable1003.has()) {
                                            hVar.f198052e.f198023b = imageRetrievalLogic$LabelSource.stLable1003.sTitle.has() ? imageRetrievalLogic$LabelSource.stLable1003.sTitle.get() : "";
                                            hVar.f198052e.f198024c = imageRetrievalLogic$LabelSource.stLable1003.sISBN.has() ? imageRetrievalLogic$LabelSource.stLable1003.sISBN.get() : "";
                                        }
                                        if (imageRetrievalLogic$LabelSource.stLable1004.has()) {
                                            hVar.f198052e.f198026e = imageRetrievalLogic$LabelSource.stLable1004.sCity.has() ? imageRetrievalLogic$LabelSource.stLable1004.sCity.get() : "";
                                            hVar.f198052e.f198025d = imageRetrievalLogic$LabelSource.stLable1004.sCountry.has() ? imageRetrievalLogic$LabelSource.stLable1004.sCountry.get() : "";
                                            hVar.f198052e.f198027f = imageRetrievalLogic$LabelSource.stLable1004.sTour.has() ? imageRetrievalLogic$LabelSource.stLable1004.sTour.get() : "";
                                        }
                                    }
                                    gVar2.f198046d[i18] = hVar;
                                }
                            }
                            acVar.f197996j[i17] = gVar2;
                            i17++;
                            list2 = list;
                        }
                    }
                }
                acVar.f198216a = acVar.l();
                acVar.f198001o = acVar.f();
                mVar.f198212j = acVar;
            }
            if (aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.has()) {
                h hVar2 = new h();
                hVar2.f198191b = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.errorcode.has() ? aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.errorcode.get() : -1;
                hVar2.f198192c = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.errormsg.has() ? aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.errormsg.get() : "";
                hVar2.f198193d = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.session_id.has() ? aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.session_id.get() : "";
                hVar2.f198194e = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errorcode.has() ? aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errorcode.get() : -1;
                hVar2.f198195f = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errormsg.has() ? aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.ar_word_detect_errormsg.get() : "";
                hVar2.f198196g = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.word_type.has() ? aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.word_type.get() : 0;
                hVar2.f198197h = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.confidence.has() ? aRCloudRecogCommonPb$ARCloudRecogRsp.msg_word_detect_result.confidence.get() : 0.0f;
                if (hVar2.c()) {
                    mVar.f198210h = hVar2;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("ARCloudRecogResult", 2, hVar2.toString());
                    }
                    mVar.f198210h = null;
                }
            } else {
                mVar.f198210h = null;
            }
            if (aRCloudRecogCommonPb$ARCloudRecogRsp.msg_ocr_result.has()) {
                com.tencent.mobileqq.ocr.data.a aVar3 = new com.tencent.mobileqq.ocr.data.a();
                ARCloudRecogCustomPb$AROcrResult aRCloudRecogCustomPb$AROcrResult = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_ocr_result.get();
                if (((aRCloudRecogCustomPb$AROcrResult.uin64_ocr_recog_type.has() ? aRCloudRecogCustomPb$AROcrResult.uin64_ocr_recog_type.get() : -1L) & 1) == 1 && aRCloudRecogCustomPb$AROcrResult.youtu_ocr_rsp.has()) {
                    aVar3.f254733a = com.tencent.mobileqq.ocr.data.a.b(aRCloudRecogCustomPb$AROcrResult.youtu_ocr_rsp.get());
                }
                mVar.f198209g = aVar3;
            } else {
                mVar.f198209g = null;
            }
            if (aRCloudRecogCommonPb$ARCloudRecogRsp.msg_face_recog_result.has()) {
                o oVar = new o();
                ARCloudRecogCustomPb$ARFaceRecogResult aRCloudRecogCustomPb$ARFaceRecogResult = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_face_recog_result.get();
                oVar.f198218a = aRCloudRecogCustomPb$ARFaceRecogResult.ar_face_recog_errorcode.has() ? aRCloudRecogCustomPb$ARFaceRecogResult.ar_face_recog_errorcode.get() : -1;
                oVar.f198219b = aRCloudRecogCustomPb$ARFaceRecogResult.ar_face_recog_errormsg.has() ? aRCloudRecogCustomPb$ARFaceRecogResult.ar_face_recog_errormsg.get() : "";
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize  faceResult.errCode_MQ = " + oVar.f198218a + ",faceResult.errMsg_MQ = " + oVar.f198219b);
                }
                if (oVar.f198218a == 0) {
                    ARCloudRecogCustomPb$ARFaceRecogRes aRCloudRecogCustomPb$ARFaceRecogRes = aRCloudRecogCustomPb$ARFaceRecogResult.image_ar_face_recog_res.has() ? aRCloudRecogCustomPb$ARFaceRecogResult.image_ar_face_recog_res.get() : null;
                    if (aRCloudRecogCustomPb$ARFaceRecogRes != null) {
                        oVar.f198220c = aRCloudRecogCustomPb$ARFaceRecogRes.errorcode.has() ? aRCloudRecogCustomPb$ARFaceRecogRes.errorcode.get() : -1;
                        oVar.f198221d = aRCloudRecogCustomPb$ARFaceRecogRes.errormsg.has() ? aRCloudRecogCustomPb$ARFaceRecogRes.errormsg.get() : "";
                        oVar.f198224g = aRCloudRecogCustomPb$ARFaceRecogRes.session_id.has() ? aRCloudRecogCustomPb$ARFaceRecogRes.session_id.get() : "";
                        oVar.f198222e = aRCloudRecogCustomPb$ARFaceRecogRes.time_ms.has() ? aRCloudRecogCustomPb$ARFaceRecogRes.time_ms.get() : -1;
                        oVar.f198223f = aRCloudRecogCustomPb$ARFaceRecogRes.group_size.has() ? aRCloudRecogCustomPb$ARFaceRecogRes.group_size.get() : -1;
                        if (QLog.isColorLevel()) {
                            QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize  faceResult.errCode_YT = " + oVar.f198220c + ",faceResult.errMsg_YT = " + oVar.f198221d + ",faceResult.sessionID = " + oVar.f198224g + ",faceResult.time_ms_YT = " + oVar.f198222e + ",faceResult.group_size_YT = " + oVar.f198223f);
                        }
                        if (oVar.f198220c == 0) {
                            List<ARCloudRecogCustomPb$StarInfo> list3 = aRCloudRecogCustomPb$ARFaceRecogRes.star_info.has() ? aRCloudRecogCustomPb$ARFaceRecogRes.star_info.get() : null;
                            if (list3 != null && list3.size() > 0) {
                                ArrayList<o.a> arrayList = new ArrayList<>();
                                for (ARCloudRecogCustomPb$StarInfo aRCloudRecogCustomPb$StarInfo : list3) {
                                    o.a aVar4 = new o.a();
                                    aVar4.f198227a = aRCloudRecogCustomPb$StarInfo.uin.has() ? aRCloudRecogCustomPb$StarInfo.uin.get() : -1L;
                                    aVar4.f198228b = aRCloudRecogCustomPb$StarInfo.face_rect_id.has() ? aRCloudRecogCustomPb$StarInfo.face_rect_id.get() : -1;
                                    aVar4.f198229c = aRCloudRecogCustomPb$StarInfo.name.has() ? aRCloudRecogCustomPb$StarInfo.name.get() : "";
                                    aVar4.f198230d = aRCloudRecogCustomPb$StarInfo.pinyin_name.has() ? aRCloudRecogCustomPb$StarInfo.pinyin_name.get() : "";
                                    aVar4.f198231e = aRCloudRecogCustomPb$StarInfo.star_wiki.has() ? aRCloudRecogCustomPb$StarInfo.star_wiki.get() : "";
                                    aVar4.f198232f = aRCloudRecogCustomPb$StarInfo.star_wiki_title.has() ? aRCloudRecogCustomPb$StarInfo.star_wiki_title.get() : "";
                                    aVar4.f198233g = aRCloudRecogCustomPb$StarInfo.star_wiki_jumpurl.has() ? aRCloudRecogCustomPb$StarInfo.star_wiki_jumpurl.get() : "";
                                    aVar4.f198234h = aRCloudRecogCustomPb$StarInfo.confidence.has() ? aRCloudRecogCustomPb$StarInfo.confidence.get() : 0.0f;
                                    arrayList.add(aVar4);
                                }
                                oVar.f198225h = arrayList;
                            }
                            oVar.f198226i = qVar.f198248i.f198199b;
                        } else {
                            FaceCluster.getInstance().releaseFaceStatusArray(qVar.f198248i.f198199b);
                        }
                    }
                } else {
                    FaceCluster.getInstance().releaseFaceStatusArray(qVar.f198248i.f198199b);
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize recog face failed from MQ, faceResult.errCode_MQ = " + oVar.f198218a + ",faceResult.errMsg_MQ = " + oVar.f198219b);
                    }
                }
                mVar.f198208f = oVar;
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace]deserialize recog face result  = " + oVar);
                }
                w.a().f198287d = System.currentTimeMillis() - qVar.f198256q;
                w.d(qVar, oVar);
            }
            if (aRCloudRecogCommonPb$ARCloudRecogRsp.msg_search_question_result.has()) {
                ARCloudRecogCustomPb$SearchQuestionResult aRCloudRecogCustomPb$SearchQuestionResult = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_search_question_result.get();
                al alVar = new al();
                alVar.f198142a = aRCloudRecogCustomPb$SearchQuestionResult.search_question_errorcode.has() ? aRCloudRecogCustomPb$SearchQuestionResult.search_question_errorcode.get() : -1;
                alVar.f198143b = aRCloudRecogCustomPb$SearchQuestionResult.search_question_errormsg.has() ? aRCloudRecogCustomPb$SearchQuestionResult.search_question_errormsg.get() : "";
                if (aRCloudRecogCommonPb$ARCloudRecogRsp.msg_search_question_result.question_res.has()) {
                    ARCloudRecogCustomPb$QuestionRes aRCloudRecogCustomPb$QuestionRes = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_search_question_result.question_res.get();
                    alVar.f198144c = aRCloudRecogCustomPb$QuestionRes.uin64_question_id.has() ? aRCloudRecogCustomPb$QuestionRes.uin64_question_id.get() : -1L;
                    alVar.f198145d = aRCloudRecogCustomPb$QuestionRes.str_question_content.has() ? aRCloudRecogCustomPb$QuestionRes.str_question_content.get() : "";
                    alVar.f198146e = aRCloudRecogCustomPb$QuestionRes.str_jump_url.has() ? aRCloudRecogCustomPb$QuestionRes.str_jump_url.get() : "";
                }
                mVar.f198211i = alVar;
            }
            if (aRCloudRecogCommonPb$ARCloudRecogRsp.msg_scene_classify_result.has()) {
                t tVar = new t();
                ARCloudRecogCustomPb$ARSceneClassifyResult aRCloudRecogCustomPb$ARSceneClassifyResult = aRCloudRecogCommonPb$ARCloudRecogRsp.msg_scene_classify_result.get();
                tVar.f198261c = aRCloudRecogCustomPb$ARSceneClassifyResult.ar_errorcode.has() ? aRCloudRecogCustomPb$ARSceneClassifyResult.ar_errorcode.get() : -1;
                tVar.f198262d = aRCloudRecogCustomPb$ARSceneClassifyResult.ar_errormsg.has() ? aRCloudRecogCustomPb$ARSceneClassifyResult.ar_errormsg.get() : "";
                if (aRCloudRecogCustomPb$ARSceneClassifyResult.image_ar_search_res.has()) {
                    ARCloudRecogCustomPb$ImageARSearchRes aRCloudRecogCustomPb$ImageARSearchRes3 = aRCloudRecogCustomPb$ARSceneClassifyResult.image_ar_search_res.get();
                    tVar.f198264f = aRCloudRecogCustomPb$ImageARSearchRes3.errorcode.has() ? aRCloudRecogCustomPb$ImageARSearchRes3.errorcode.get() : -1;
                    tVar.f198265g = aRCloudRecogCustomPb$ImageARSearchRes3.errormsg.has() ? aRCloudRecogCustomPb$ImageARSearchRes3.errormsg.get() : "";
                    tVar.f198266h = aRCloudRecogCustomPb$ImageARSearchRes3.session_id.has() ? aRCloudRecogCustomPb$ImageARSearchRes3.session_id.get() : "";
                    if (aRCloudRecogCustomPb$ImageARSearchRes3.tags.has() && aRCloudRecogCustomPb$ImageARSearchRes3.tags.size() > 0) {
                        int size4 = aRCloudRecogCustomPb$ImageARSearchRes3.tags.size();
                        tVar.f198267i = new t.a[size4];
                        for (int i19 = 0; i19 < size4; i19++) {
                            t.a aVar5 = new t.a();
                            ARCloudRecogCustomPb$ImageARTag aRCloudRecogCustomPb$ImageARTag3 = aRCloudRecogCustomPb$ImageARSearchRes3.tags.get(i19);
                            aVar5.f198271a = aRCloudRecogCustomPb$ImageARTag3.image_id.has() ? aRCloudRecogCustomPb$ImageARTag3.image_id.get() : "";
                            aVar5.f198272b = aRCloudRecogCustomPb$ImageARTag3.tag_name.has() ? aRCloudRecogCustomPb$ImageARTag3.tag_name.get() : "";
                            aVar5.f198273c = aRCloudRecogCustomPb$ImageARTag3.tag_confidence.has() ? aRCloudRecogCustomPb$ImageARTag3.tag_confidence.get() : 0;
                            aVar5.f198274d = aRCloudRecogCustomPb$ImageARTag3.tag_confidence_f.has() ? aRCloudRecogCustomPb$ImageARTag3.tag_confidence_f.get() : 0.0f;
                            aVar5.f198275e = aRCloudRecogCustomPb$ImageARTag3.need_check_lbs.has() ? aRCloudRecogCustomPb$ImageARTag3.need_check_lbs.get() : 0;
                            aVar5.f198276f = aRCloudRecogCustomPb$ImageARTag3.cdb_errorcode.has() ? aRCloudRecogCustomPb$ImageARTag3.cdb_errorcode.get() : -1;
                            aVar5.f198277g = aRCloudRecogCustomPb$ImageARTag3.cdb_res.has() ? aRCloudRecogCustomPb$ImageARTag3.cdb_res.get().toByteArray() : null;
                            tVar.f198267i[i19] = aVar5;
                        }
                        if (size4 > 0) {
                            tVar.f198216a = tVar.f198267i[0].f198275e == 1;
                        }
                    } else {
                        tVar.f198267i = null;
                    }
                    tVar.f198268j = aRCloudRecogCustomPb$ImageARSearchRes3.time_ms.has() ? aRCloudRecogCustomPb$ImageARSearchRes3.time_ms.get() : 0;
                    tVar.f198269k = aRCloudRecogCustomPb$ImageARSearchRes3.score.has() ? aRCloudRecogCustomPb$ImageARSearchRes3.score.get() : 0;
                    tVar.f198270l = aRCloudRecogCustomPb$ImageARSearchRes3.kpt_num.has() ? aRCloudRecogCustomPb$ImageARSearchRes3.kpt_num.get() : 0;
                } else {
                    tVar.f198264f = -1;
                    tVar.f198265g = "";
                    tVar.f198266h = "";
                    tVar.f198267i = null;
                    tVar.f198268j = 0;
                    tVar.f198269k = 0;
                    tVar.f198270l = 0;
                }
                mVar.f198213k = tVar;
            } else {
                mVar.f198213k = null;
            }
            long j3 = aRCloudRecogCommonPb$ARCloudRecogRsp.uint64_uin.has() ? aRCloudRecogCommonPb$ARCloudRecogRsp.uint64_uin.get() : 0L;
            mVar.f198215m = j3;
            try {
                if (j3 == Long.parseLong(this.f441222a.getCurrentAccountUin())) {
                    return mVar;
                }
                QLog.i("AREngine_ARCloudFileUpload", 1, "deserialize pb failed. error uin. recogResult.uin = " + mVar.f198215m);
                return null;
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
                QLog.i("AREngine_ARCloudFileUpload", 1, "deserialize pb failed. error msg = " + e.getMessage());
                return null;
            }
        } catch (InvalidProtocolBufferMicroException e17) {
            e = e17;
        }
    }

    public static String j(AppInterface appInterface) {
        return String.format("%s_%s_%05d", appInterface.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)));
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:73), block:B:42:0x0048 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0036 -> B:9:0x0046). Please report as a decompilation issue!!! */
    public static byte[] k(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        byte[] hexStr2Bytes;
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        FileInputStream fileInputStream3 = null;
        try {
            try {
                try {
                    File file = new File(str);
                    fileInputStream2 = new FileInputStream(file);
                    try {
                        try {
                            hexStr2Bytes = MD5.toMD5Byte(fileInputStream2, file.length());
                        } catch (Exception e16) {
                            e = e16;
                            e.printStackTrace();
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            return bArr;
                        }
                    } catch (UnsatisfiedLinkError unused) {
                        File file2 = new File(str);
                        if (file2.exists()) {
                            try {
                                String d16 = com.tencent.qqprotect.singleupdate.a.d(file2);
                                if (d16 == null) {
                                    d16 = "";
                                }
                                hexStr2Bytes = HexUtil.hexStr2Bytes(d16);
                            } catch (IOException unused2) {
                            }
                        }
                    }
                    bArr = hexStr2Bytes;
                    fileInputStream2.close();
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e19) {
                e19.printStackTrace();
            }
            return bArr;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream3 = fileInputStream;
        }
    }

    private byte[] o(q qVar) {
        FaceStatus[] faceStatusArr;
        ARCloudRecogCommonPb$ARCloudRecogReq aRCloudRecogCommonPb$ARCloudRecogReq = new ARCloudRecogCommonPb$ARCloudRecogReq();
        aRCloudRecogCommonPb$ARCloudRecogReq.str_session_id.set(qVar.f198240a);
        ARCloudRecogCommonPb$ARFileReqInfo aRCloudRecogCommonPb$ARFileReqInfo = new ARCloudRecogCommonPb$ARFileReqInfo();
        aRCloudRecogCommonPb$ARFileReqInfo.str_file_name.set(qVar.f198241b.f198235a);
        aRCloudRecogCommonPb$ARFileReqInfo.uint32_file_format.set(qVar.f198241b.f198236b);
        aRCloudRecogCommonPb$ARCloudRecogReq.msg_ar_req_file_info.set(aRCloudRecogCommonPb$ARFileReqInfo);
        aRCloudRecogCommonPb$ARCloudRecogReq.uint32_lon.set(qVar.f198242c);
        aRCloudRecogCommonPb$ARCloudRecogReq.uint32_lat.set(qVar.f198243d);
        aRCloudRecogCommonPb$ARCloudRecogReq.uin32_business_type.set(qVar.f198245f);
        long j3 = qVar.f198244e;
        if ((1 & j3) != 0) {
            ARCloudRecogCustomPb$ARMarkerRecogInfo aRCloudRecogCustomPb$ARMarkerRecogInfo = new ARCloudRecogCustomPb$ARMarkerRecogInfo();
            aRCloudRecogCustomPb$ARMarkerRecogInfo.uin32_timeout_ms.set(qVar.f198246g.f198257a);
            aRCloudRecogCommonPb$ARCloudRecogReq.msg_ar_marker_recog_info.set(aRCloudRecogCustomPb$ARMarkerRecogInfo);
        }
        if ((2 & j3) != 0) {
            ARCloudRecogCustomPb$ARObjectClassifyInfo aRCloudRecogCustomPb$ARObjectClassifyInfo = new ARCloudRecogCustomPb$ARObjectClassifyInfo();
            aRCloudRecogCustomPb$ARObjectClassifyInfo.uin32_timeout_ms.set(qVar.f198247h.f198200a);
            aRCloudRecogCommonPb$ARCloudRecogReq.msg_object_classify_info.set(aRCloudRecogCustomPb$ARObjectClassifyInfo);
        }
        if ((128 & j3) != 0) {
            ARCloudRecogCustomPb$ImgRetrievalInfo aRCloudRecogCustomPb$ImgRetrievalInfo = new ARCloudRecogCustomPb$ImgRetrievalInfo();
            aRCloudRecogCustomPb$ImgRetrievalInfo.uin32_timeout_ms.set(qVar.f198250k.f198200a);
            aRCloudRecogCommonPb$ARCloudRecogReq.msg_img_retrieval_info.set(aRCloudRecogCustomPb$ImgRetrievalInfo);
        }
        if ((64 & j3) != 0) {
            ARCloudRecogCustomPb$ARWordDetectInfo aRCloudRecogCustomPb$ARWordDetectInfo = new ARCloudRecogCustomPb$ARWordDetectInfo();
            aRCloudRecogCustomPb$ARWordDetectInfo.uin32_timeout_ms.set(qVar.f198249j.f198201a);
            aRCloudRecogCommonPb$ARCloudRecogReq.msg_word_detect_info.set(aRCloudRecogCustomPb$ARWordDetectInfo);
        }
        if ((16 & j3) != 0) {
            ARCloudRecogCustomPb$AROcrInfo aRCloudRecogCustomPb$AROcrInfo = new ARCloudRecogCustomPb$AROcrInfo();
            YoutuOcr$YoutuOcrReq youtuOcr$YoutuOcrReq = new YoutuOcr$YoutuOcrReq();
            youtuOcr$YoutuOcrReq.uin32_timeout_ms.set(30000);
            com.tencent.mobileqq.ocr.a aVar = qVar.f198252m;
            if (aVar != null && !TextUtils.isEmpty(aVar.f254625a)) {
                youtuOcr$YoutuOcrReq.language.set(qVar.f198252m.f254625a);
            } else {
                youtuOcr$YoutuOcrReq.language.set("auto");
            }
            JDSearch$JdSearchReq jDSearch$JdSearchReq = new JDSearch$JdSearchReq();
            jDSearch$JdSearchReq.uin32_timeout_ms.set(30000);
            aRCloudRecogCustomPb$AROcrInfo.uin64_ocr_recog_type.set(17);
            aRCloudRecogCustomPb$AROcrInfo.youtu_ocr_req.set(youtuOcr$YoutuOcrReq);
            aRCloudRecogCustomPb$AROcrInfo.jd_search_req.set(jDSearch$JdSearchReq);
            aRCloudRecogCommonPb$ARCloudRecogReq.msg_ocr_info.set(aRCloudRecogCustomPb$AROcrInfo);
        }
        if ((4 & j3) != 0) {
            i iVar = qVar.f198248i;
            if (iVar != null && (faceStatusArr = iVar.f198199b) != null && faceStatusArr.length > 0) {
                ARCloudRecogCustomPb$ARFaceRecogInfo aRCloudRecogCustomPb$ARFaceRecogInfo = new ARCloudRecogCustomPb$ARFaceRecogInfo();
                ArrayList arrayList = new ArrayList();
                int length = qVar.f198248i.f198199b.length;
                for (int i3 = 0; i3 < length; i3++) {
                    FaceStatus faceStatus = qVar.f198248i.f198199b[i3];
                    ARCloudRecogCustomPb$FaceRect aRCloudRecogCustomPb$FaceRect = new ARCloudRecogCustomPb$FaceRect();
                    aRCloudRecogCustomPb$FaceRect.face_rect_id.set(i3);
                    aRCloudRecogCustomPb$FaceRect.face_origin_x.set(faceStatus.f61315x);
                    aRCloudRecogCustomPb$FaceRect.face_origin_y.set(faceStatus.f61316y);
                    aRCloudRecogCustomPb$FaceRect.face_size_w.set(faceStatus.width);
                    aRCloudRecogCustomPb$FaceRect.face_size_h.set(faceStatus.height);
                    arrayList.add(aRCloudRecogCustomPb$FaceRect);
                }
                aRCloudRecogCustomPb$ARFaceRecogInfo.uin32_timeout_ms.set(qVar.f198248i.f198198a);
                aRCloudRecogCustomPb$ARFaceRecogInfo.face_rect.set(arrayList);
                aRCloudRecogCommonPb$ARCloudRecogReq.msg_face_recog_info.set(aRCloudRecogCustomPb$ARFaceRecogInfo);
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARCloudFileUpload", 2, "[ScanStarFace] serialize add faceRectInfo");
                }
            } else {
                j3 &= -5;
            }
        }
        if ((512 & j3) != 0) {
            ARCloudRecogCustomPb$SearchQuestionInfo aRCloudRecogCustomPb$SearchQuestionInfo = new ARCloudRecogCustomPb$SearchQuestionInfo();
            aRCloudRecogCustomPb$SearchQuestionInfo.uin32_timeout_ms.set(30000);
            aRCloudRecogCustomPb$SearchQuestionInfo.uin64_pic_height.set(qVar.f198241b.f198237c);
            aRCloudRecogCustomPb$SearchQuestionInfo.uin64_pic_width.set(qVar.f198241b.f198238d);
            aRCloudRecogCommonPb$ARCloudRecogReq.msg_search_question_info.set(aRCloudRecogCustomPb$SearchQuestionInfo);
        }
        if ((2048 & j3) != 0) {
            ARCloudRecogCustomPb$ARSceneClassifyInfo aRCloudRecogCustomPb$ARSceneClassifyInfo = new ARCloudRecogCustomPb$ARSceneClassifyInfo();
            aRCloudRecogCustomPb$ARSceneClassifyInfo.uin32_timeout_ms.set(qVar.f198251l.f198202a);
            aRCloudRecogCommonPb$ARCloudRecogReq.msg_scene_classify_info.set(aRCloudRecogCustomPb$ARSceneClassifyInfo);
        }
        if ((8192 & j3) != 0) {
            ARCloudRecogCustomPb$ImageTranslateReqInfo aRCloudRecogCustomPb$ImageTranslateReqInfo = new ARCloudRecogCustomPb$ImageTranslateReqInfo();
            s sVar = qVar.f198253n;
            if (sVar != null) {
                aRCloudRecogCustomPb$ImageTranslateReqInfo.session_uuid.set(ByteStringMicro.copyFromUtf8(sVar.f198258a));
                aRCloudRecogCustomPb$ImageTranslateReqInfo.source_lang.set(ByteStringMicro.copyFromUtf8(qVar.f198253n.b()));
                aRCloudRecogCustomPb$ImageTranslateReqInfo.target_lang.set(ByteStringMicro.copyFromUtf8(qVar.f198253n.a()));
                aRCloudRecogCustomPb$ImageTranslateReqInfo.plateform.set(ByteStringMicro.copyFromUtf8("android"));
            }
            aRCloudRecogCommonPb$ARCloudRecogReq.msg_image_translate_req_info.set(aRCloudRecogCustomPb$ImageTranslateReqInfo);
        }
        aRCloudRecogCommonPb$ARCloudRecogReq.uin64_req_recog_type.set(j3);
        aRCloudRecogCommonPb$ARCloudRecogReq.str_clt_version.set(qVar.f198254o);
        aRCloudRecogCommonPb$ARCloudRecogReq.uint64_uin.set(qVar.f198255p);
        return aRCloudRecogCommonPb$ARCloudRecogReq.toByteArray();
    }

    public int e() {
        int i3;
        synchronized (this.f441225d) {
            ArrayList<e> arrayList = this.f441223b;
            i3 = 0;
            if (arrayList != null) {
                int size = arrayList.size();
                while (i3 < this.f441223b.size()) {
                    QLog.i("AREngine_ARCloudFileUpload", 1, "cancelTransactionTask. sessionId = " + this.f441223b.get(i3).f441234b.f198240a);
                    this.f441222a.getHwEngine().cancelTransactionTask(this.f441223b.get(i3).f441235c);
                    i3++;
                }
                this.f441223b.clear();
                i3 = size;
            }
        }
        return i3;
    }

    public void g() {
        com.tencent.mobileqq.ar.d dVar = this.f441228g;
        if (dVar != null) {
            this.f441222a.removeObserver(dVar);
        }
    }

    public void h(boolean z16) {
        if (!z16) {
            return;
        }
        C11401a c11401a = new C11401a();
        this.f441228g = c11401a;
        this.f441222a.addObserver(c11401a);
    }

    public String i() {
        return j(this.f441222a);
    }

    public void l() {
        AppInterface appInterface = this.f441222a;
        if (appInterface != null) {
            appInterface.getHwEngine().preConnect();
        }
    }

    public boolean m(String str, int i3, int i16, d dVar) {
        QLog.i("AREngine_ARCloudFileUpload", 1, "requestToCheckLBSLocation. imageId = " + str + ", latitude = " + i3 + ", longitude = " + i16);
        this.f441226e = str;
        this.f441227f = dVar;
        ((ARLBSHandler) this.f441222a.getBusinessHandler(com.tencent.mobileqq.armap.a.f199722b)).E2(str, i3, i16);
        return true;
    }

    public boolean n(q qVar, c cVar) {
        int submitTransactionTask;
        if (qVar != null && cVar != null) {
            b bVar = new b(qVar, new File(qVar.f198241b.f198235a).length());
            String currentAccountUin = this.f441222a.getCurrentAccountUin();
            byte[] bArr = this.f441224c;
            if (bArr == null || bArr.length == 0) {
                synchronized (SessionInfo.class) {
                    if (SessionInfo.getInstance(currentAccountUin).getHttpconn_sig_session() != null) {
                        int length = SessionInfo.getInstance(currentAccountUin).getHttpconn_sig_session().length;
                        this.f441224c = new byte[length];
                        System.arraycopy(SessionInfo.getInstance(currentAccountUin).getHttpconn_sig_session(), 0, this.f441224c, 0, length);
                    }
                }
            }
            byte[] bArr2 = this.f441224c;
            if (bArr2 != null && bArr2.length != 0) {
                byte[] k3 = k(qVar.f198241b.f198235a);
                if (k3 != null && k3.length != 0) {
                    Transaction transaction = new Transaction(currentAccountUin, 42, qVar.f198241b.f198235a, 0, this.f441224c, k3, bVar, o(qVar));
                    e eVar = new e();
                    eVar.f441233a = qVar.f198241b.f198235a;
                    eVar.f441234b = qVar;
                    eVar.f441235c = transaction;
                    eVar.f441236d = cVar;
                    synchronized (this.f441225d) {
                        this.f441223b.add(eVar);
                        submitTransactionTask = this.f441222a.getHwEngine().submitTransactionTask(transaction);
                        QLog.i("AREngine_ARCloudFileUpload", 1, "submitTransactionTask. retCode = " + submitTransactionTask + ", reqInfo = " + qVar);
                    }
                    if (submitTransactionTask == 0) {
                        return true;
                    }
                    return false;
                }
                QLog.i("AREngine_ARCloudFileUpload", 1, "requestToUpload failed. fileMd5 == null || fileMd5.length == 0.");
                return false;
            }
            HwServlet.getConfig(this.f441222a, currentAccountUin);
            QLog.i("AREngine_ARCloudFileUpload", 1, "requestToUpload failed. mSigSession == null || mSigSession.length == 0.");
            return false;
        }
        QLog.i("AREngine_ARCloudFileUpload", 1, "reqInfo == null || callBack == null");
        return false;
    }

    public a(AppInterface appInterface, boolean z16) {
        this.f441223b = null;
        this.f441224c = null;
        this.f441225d = new Object();
        this.f441226e = "";
        this.f441227f = null;
        this.f441228g = null;
        this.f441222a = appInterface;
        this.f441223b = new ArrayList<>();
        h(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements ITransactionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f441230a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f441231b;

        b(q qVar, long j3) {
            this.f441230a = qVar;
            this.f441231b = j3;
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onFailed(int i3, byte[] bArr, HashMap<String, String> hashMap) {
            c cVar;
            String str = "";
            synchronized (a.this.f441225d) {
                if (a.this.f441223b != null) {
                    for (int i16 = 0; i16 < a.this.f441223b.size(); i16++) {
                        if (((e) a.this.f441223b.get(i16)).f441234b.f198240a.equals(this.f441230a.f198240a)) {
                            c cVar2 = ((e) a.this.f441223b.get(i16)).f441236d;
                            String str2 = ((e) a.this.f441223b.get(i16)).f441234b.f198240a;
                            a.this.f441223b.remove(i16);
                            cVar = cVar2;
                            str = str2;
                            break;
                        }
                    }
                }
                cVar = null;
            }
            QLog.i("AREngine_ARCloudFileUpload", 1, "Upload failed. retCode = " + i3 + ", IP = " + hashMap.get("ip") + ", sessionId = " + str);
            if (cVar != null) {
                cVar.a(i3, str, null);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
            int i3;
            c cVar;
            String str = "";
            synchronized (a.this.f441225d) {
                i3 = 0;
                if (a.this.f441223b != null) {
                    for (int i16 = 0; i16 < a.this.f441223b.size(); i16++) {
                        if (((e) a.this.f441223b.get(i16)).f441234b.f198240a.equals(this.f441230a.f198240a)) {
                            c cVar2 = ((e) a.this.f441223b.get(i16)).f441236d;
                            String str2 = ((e) a.this.f441223b.get(i16)).f441234b.f198240a;
                            a.this.f441223b.remove(i16);
                            cVar = cVar2;
                            str = str2;
                            break;
                        }
                    }
                }
                cVar = null;
            }
            m f16 = a.this.f(bArr, this.f441230a);
            if (f16 == null) {
                QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + AppConstants.RichMediaErrorCode.ERROR_EXP_DECODER + ", IP = " + hashMap.get("ip") + ", sessionId = " + str + ". deserialize pb failed.");
                i3 = 9058;
            } else {
                QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = 0, IP = " + hashMap.get("ip") + ", sessionId = " + str);
            }
            if (cVar != null) {
                cVar.a(i3, str, f16);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onTransStart() {
            QLog.i("AREngine_ARCloudFileUpload", 1, "Upload start. sessionId = " + this.f441230a.f198240a);
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onUpdateProgress(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARCloudFileUpload", 2, "onUpdateProgress. sessionId = " + this.f441230a.f198240a + ". total size = " + this.f441231b + ", transfered size = " + i3);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSwitch2BackupChannel() {
        }
    }
}
