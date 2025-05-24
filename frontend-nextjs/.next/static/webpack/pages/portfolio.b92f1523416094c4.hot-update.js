/*
 * ATTENTION: An "eval-source-map" devtool has been used.
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file with attached SourceMaps in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
self["webpackHotUpdate_N_E"]("pages/portfolio",{

/***/ "./components/MutualFundTable.tsx":
/*!****************************************!*\
  !*** ./components/MutualFundTable.tsx ***!
  \****************************************/
/***/ (function(module, __unused_webpack_exports, __webpack_require__) {



;
    // Wrapped in an IIFE to avoid polluting the global scope
    ;
    (function () {
        var _a, _b;
        // Legacy CSS implementations will `eval` browser code in a Node.js context
        // to extract CSS. For backwards compatibility, we need to check we're in a
        // browser context before continuing.
        if (typeof self !== 'undefined' &&
            // AMP / No-JS mode does not inject these helpers:
            '$RefreshHelpers$' in self) {
            // @ts-ignore __webpack_module__ is global
            var currentExports = module.exports;
            // @ts-ignore __webpack_module__ is global
            var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;
            // This cannot happen in MainTemplate because the exports mismatch between
            // templating and execution.
            self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.id);
            // A module can be accepted automatically based on its exports, e.g. when
            // it is a Refresh Boundary.
            if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {
                // Save the previous exports on update so we can compare the boundary
                // signatures.
                module.hot.dispose(function (data) {
                    data.prevExports = currentExports;
                });
                // Unconditionally accept an update to this module, we'll check if it's
                // still a Refresh Boundary later.
                // @ts-ignore importMeta is replaced in the loader
                module.hot.accept();
                // This field is set when the previous version of this module was a
                // Refresh Boundary, letting us know we need to check for invalidation or
                // enqueue an update.
                if (prevExports !== null) {
                    // A boundary can become ineligible if its exports are incompatible
                    // with the previous exports.
                    //
                    // For example, if you add/remove/change exports, we'll want to
                    // re-execute the importing modules, and force those components to
                    // re-render. Similarly, if you convert a class component to a
                    // function, we want to invalidate the boundary.
                    if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {
                        module.hot.invalidate();
                    }
                    else {
                        self.$RefreshHelpers$.scheduleUpdate();
                    }
                }
            }
            else {
                // Since we just executed the code for the module, it's possible that the
                // new exports made it ineligible for being a boundary.
                // We only care about the case when we were _previously_ a boundary,
                // because we already accepted this update (accidental side effect).
                var isNoLongerABoundary = prevExports !== null;
                if (isNoLongerABoundary) {
                    module.hot.invalidate();
                }
            }
        }
    })();


/***/ }),

/***/ "./pages/portfolio.tsx":
/*!*****************************!*\
  !*** ./pages/portfolio.tsx ***!
  \*****************************/
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval(__webpack_require__.ts("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": function() { return /* binding */ PortfolioPage; }\n/* harmony export */ });\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react/jsx-dev-runtime */ \"./node_modules/react/jsx-dev-runtime.js\");\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var _components_Header__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../components/Header */ \"./components/Header.tsx\");\n/* harmony import */ var _components_Footer__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../components/Footer */ \"./components/Footer.tsx\");\n/* harmony import */ var _components_NavBar__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../components/NavBar */ \"./components/NavBar.tsx\");\n/* harmony import */ var _components_PortfolioTable__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../components/PortfolioTable */ \"./components/PortfolioTable.tsx\");\n/* harmony import */ var _components_CurrencySelector__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../components/CurrencySelector */ \"./components/CurrencySelector.tsx\");\n/* harmony import */ var _components_FundSummaryCard__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../components/FundSummaryCard */ \"./components/FundSummaryCard.tsx\");\n/* harmony import */ var _components_MutualFundTable__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../components/MutualFundTable */ \"./components/MutualFundTable.tsx\");\n/* harmony import */ var _components_MutualFundTable__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(_components_MutualFundTable__WEBPACK_IMPORTED_MODULE_7__);\n\n\n\n\n\n\n\n\nfunction PortfolioPage() {\n    return /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n        className: \"min-h-screen flex flex-col\",\n        children: [\n            /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_components_Header__WEBPACK_IMPORTED_MODULE_1__[\"default\"], {}, void 0, false, {\n                fileName: \"C:\\\\Users\\\\Lim Yi Han\\\\IdeaProjects\\\\fund-portfolio\\\\mutual-portfolio-ui\\\\frontend-nextjs\\\\pages\\\\portfolio.tsx\",\n                lineNumber: 12,\n                columnNumber: 7\n            }, this),\n            /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_components_NavBar__WEBPACK_IMPORTED_MODULE_3__[\"default\"], {}, void 0, false, {\n                fileName: \"C:\\\\Users\\\\Lim Yi Han\\\\IdeaProjects\\\\fund-portfolio\\\\mutual-portfolio-ui\\\\frontend-nextjs\\\\pages\\\\portfolio.tsx\",\n                lineNumber: 13,\n                columnNumber: 7\n            }, this),\n            /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"main\", {\n                className: \"flex-1 p-4\",\n                children: [\n                    /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_components_CurrencySelector__WEBPACK_IMPORTED_MODULE_5__[\"default\"], {}, void 0, false, {\n                        fileName: \"C:\\\\Users\\\\Lim Yi Han\\\\IdeaProjects\\\\fund-portfolio\\\\mutual-portfolio-ui\\\\frontend-nextjs\\\\pages\\\\portfolio.tsx\",\n                        lineNumber: 15,\n                        columnNumber: 9\n                    }, this),\n                    /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_components_FundSummaryCard__WEBPACK_IMPORTED_MODULE_6__[\"default\"], {}, void 0, false, {\n                        fileName: \"C:\\\\Users\\\\Lim Yi Han\\\\IdeaProjects\\\\fund-portfolio\\\\mutual-portfolio-ui\\\\frontend-nextjs\\\\pages\\\\portfolio.tsx\",\n                        lineNumber: 16,\n                        columnNumber: 9\n                    }, this),\n                    /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)((_components_MutualFundTable__WEBPACK_IMPORTED_MODULE_7___default()), {}, void 0, false, {\n                        fileName: \"C:\\\\Users\\\\Lim Yi Han\\\\IdeaProjects\\\\fund-portfolio\\\\mutual-portfolio-ui\\\\frontend-nextjs\\\\pages\\\\portfolio.tsx\",\n                        lineNumber: 17,\n                        columnNumber: 9\n                    }, this),\n                    /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_components_PortfolioTable__WEBPACK_IMPORTED_MODULE_4__[\"default\"], {}, void 0, false, {\n                        fileName: \"C:\\\\Users\\\\Lim Yi Han\\\\IdeaProjects\\\\fund-portfolio\\\\mutual-portfolio-ui\\\\frontend-nextjs\\\\pages\\\\portfolio.tsx\",\n                        lineNumber: 18,\n                        columnNumber: 9\n                    }, this)\n                ]\n            }, void 0, true, {\n                fileName: \"C:\\\\Users\\\\Lim Yi Han\\\\IdeaProjects\\\\fund-portfolio\\\\mutual-portfolio-ui\\\\frontend-nextjs\\\\pages\\\\portfolio.tsx\",\n                lineNumber: 14,\n                columnNumber: 7\n            }, this),\n            /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_components_Footer__WEBPACK_IMPORTED_MODULE_2__[\"default\"], {}, void 0, false, {\n                fileName: \"C:\\\\Users\\\\Lim Yi Han\\\\IdeaProjects\\\\fund-portfolio\\\\mutual-portfolio-ui\\\\frontend-nextjs\\\\pages\\\\portfolio.tsx\",\n                lineNumber: 20,\n                columnNumber: 7\n            }, this)\n        ]\n    }, void 0, true, {\n        fileName: \"C:\\\\Users\\\\Lim Yi Han\\\\IdeaProjects\\\\fund-portfolio\\\\mutual-portfolio-ui\\\\frontend-nextjs\\\\pages\\\\portfolio.tsx\",\n        lineNumber: 11,\n        columnNumber: 5\n    }, this);\n}\n_c = PortfolioPage;\nvar _c;\n$RefreshReg$(_c, \"PortfolioPage\");\n\n\n;\n    // Wrapped in an IIFE to avoid polluting the global scope\n    ;\n    (function () {\n        var _a, _b;\n        // Legacy CSS implementations will `eval` browser code in a Node.js context\n        // to extract CSS. For backwards compatibility, we need to check we're in a\n        // browser context before continuing.\n        if (typeof self !== 'undefined' &&\n            // AMP / No-JS mode does not inject these helpers:\n            '$RefreshHelpers$' in self) {\n            // @ts-ignore __webpack_module__ is global\n            var currentExports = module.exports;\n            // @ts-ignore __webpack_module__ is global\n            var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;\n            // This cannot happen in MainTemplate because the exports mismatch between\n            // templating and execution.\n            self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.id);\n            // A module can be accepted automatically based on its exports, e.g. when\n            // it is a Refresh Boundary.\n            if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {\n                // Save the previous exports on update so we can compare the boundary\n                // signatures.\n                module.hot.dispose(function (data) {\n                    data.prevExports = currentExports;\n                });\n                // Unconditionally accept an update to this module, we'll check if it's\n                // still a Refresh Boundary later.\n                // @ts-ignore importMeta is replaced in the loader\n                module.hot.accept();\n                // This field is set when the previous version of this module was a\n                // Refresh Boundary, letting us know we need to check for invalidation or\n                // enqueue an update.\n                if (prevExports !== null) {\n                    // A boundary can become ineligible if its exports are incompatible\n                    // with the previous exports.\n                    //\n                    // For example, if you add/remove/change exports, we'll want to\n                    // re-execute the importing modules, and force those components to\n                    // re-render. Similarly, if you convert a class component to a\n                    // function, we want to invalidate the boundary.\n                    if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {\n                        module.hot.invalidate();\n                    }\n                    else {\n                        self.$RefreshHelpers$.scheduleUpdate();\n                    }\n                }\n            }\n            else {\n                // Since we just executed the code for the module, it's possible that the\n                // new exports made it ineligible for being a boundary.\n                // We only care about the case when we were _previously_ a boundary,\n                // because we already accepted this update (accidental side effect).\n                var isNoLongerABoundary = prevExports !== null;\n                if (isNoLongerABoundary) {\n                    module.hot.invalidate();\n                }\n            }\n        }\n    })();\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9wYWdlcy9wb3J0Zm9saW8udHN4IiwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7Ozs7OztBQUEwQztBQUNBO0FBQ0E7QUFDZ0I7QUFDSTtBQUNGO0FBQ0E7QUFFN0MsU0FBU087SUFDdEIscUJBQ0UsOERBQUNDO1FBQUlDLFdBQVU7OzBCQUNiLDhEQUFDVCwwREFBTUE7Ozs7OzBCQUNQLDhEQUFDRSwwREFBTUE7Ozs7OzBCQUNQLDhEQUFDUTtnQkFBS0QsV0FBVTs7a0NBQ2QsOERBQUNMLG9FQUFnQkE7Ozs7O2tDQUNqQiw4REFBQ0MsbUVBQWVBOzs7OztrQ0FDaEIsOERBQUNDLG9FQUFlQTs7Ozs7a0NBQ2hCLDhEQUFDSCxrRUFBY0E7Ozs7Ozs7Ozs7OzBCQUVqQiw4REFBQ0YsMERBQU1BOzs7Ozs7Ozs7OztBQUdiO0tBZHdCTSIsInNvdXJjZXMiOlsid2VicGFjazovL19OX0UvLi9wYWdlcy9wb3J0Zm9saW8udHN4P2RhZTUiXSwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IEhlYWRlciBmcm9tICcuLi9jb21wb25lbnRzL0hlYWRlcic7XG5pbXBvcnQgRm9vdGVyIGZyb20gJy4uL2NvbXBvbmVudHMvRm9vdGVyJztcbmltcG9ydCBOYXZCYXIgZnJvbSAnLi4vY29tcG9uZW50cy9OYXZCYXInO1xuaW1wb3J0IFBvcnRmb2xpb1RhYmxlIGZyb20gJy4uL2NvbXBvbmVudHMvUG9ydGZvbGlvVGFibGUnO1xuaW1wb3J0IEN1cnJlbmN5U2VsZWN0b3IgZnJvbSAnLi4vY29tcG9uZW50cy9DdXJyZW5jeVNlbGVjdG9yJztcbmltcG9ydCBGdW5kU3VtbWFyeUNhcmQgZnJvbSAnLi4vY29tcG9uZW50cy9GdW5kU3VtbWFyeUNhcmQnO1xuaW1wb3J0IE11dHVhbEZ1bmRUYWJsZSBmcm9tICcuLi9jb21wb25lbnRzL011dHVhbEZ1bmRUYWJsZSc7XG5cbmV4cG9ydCBkZWZhdWx0IGZ1bmN0aW9uIFBvcnRmb2xpb1BhZ2UoKSB7XG4gIHJldHVybiAoXG4gICAgPGRpdiBjbGFzc05hbWU9XCJtaW4taC1zY3JlZW4gZmxleCBmbGV4LWNvbFwiPlxuICAgICAgPEhlYWRlciAvPlxuICAgICAgPE5hdkJhciAvPlxuICAgICAgPG1haW4gY2xhc3NOYW1lPVwiZmxleC0xIHAtNFwiPlxuICAgICAgICA8Q3VycmVuY3lTZWxlY3RvciAvPlxuICAgICAgICA8RnVuZFN1bW1hcnlDYXJkIC8+XG4gICAgICAgIDxNdXR1YWxGdW5kVGFibGUgLz5cbiAgICAgICAgPFBvcnRmb2xpb1RhYmxlIC8+XG4gICAgICA8L21haW4+XG4gICAgICA8Rm9vdGVyIC8+XG4gICAgPC9kaXY+XG4gICk7XG59XG4iXSwibmFtZXMiOlsiSGVhZGVyIiwiRm9vdGVyIiwiTmF2QmFyIiwiUG9ydGZvbGlvVGFibGUiLCJDdXJyZW5jeVNlbGVjdG9yIiwiRnVuZFN1bW1hcnlDYXJkIiwiTXV0dWFsRnVuZFRhYmxlIiwiUG9ydGZvbGlvUGFnZSIsImRpdiIsImNsYXNzTmFtZSIsIm1haW4iXSwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///./pages/portfolio.tsx\n"));

/***/ })

});